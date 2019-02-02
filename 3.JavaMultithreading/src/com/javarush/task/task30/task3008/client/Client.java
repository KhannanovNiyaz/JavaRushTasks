package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Клиент, в начале своей работы, должен запросить у пользователя адрес и порт сервера, подсоединиться к указанному адресу,
 * получить запрос имени от сервера, спросить имя у пользователя, отправить имя пользователя серверу, дождаться принятия
 * имени сервером. После этого клиент может обмениваться текстовыми сообщениями с сервером. Обмен сообщениями будет
 * происходить в двух параллельно работающих потоках. Один будет заниматься чтением из консоли и отправкой прочитанного
 * серверу, а второй поток будет получать данные от сервера и выводить их в консоль.
 */


/*
Последний, но самый главный метод класса SocketThread - это метод void run(). Добавь его.
 Его реализация с учетом уже созданных методов выглядит очень просто.

Давай напишем ее:
1) Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
2) Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.
3) Создай объект класса Connection, используя сокет из п.17.2.
4) Вызови метод, реализующий "рукопожатие" клиента с сервером (clientHandshake()).
5) Вызови метод, реализующий основной цикл обработки сообщений сервера.
6) При возникновении исключений IOException или ClassNotFoundException сообщи главному потоку о проблеме,
используя notifyConnectionStatusChanged и false в качестве параметра.

Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.

Требования:
1. В методе run должно быть установлено и сохранено в поле connection соединение с сервером (для получения
адреса сервера и порта используй методы getServerAddress и getServerPort).
2. В методе run должен быть вызван метод clientHandshake.
3. В методе run должен быть вызван метод clientMainLoop.
4. При возникновении исключений IOException или ClassNotFoundException в процессе работы метода run, должен
быть вызван метод notifyConnectionStatusChanged с параметром false.
5. Заголовок метода run должен соответствовать условию задачи.
* */
public class Client {

    //    SocketThread будет отвечать за поток, устанавливающий сокетное соединение и читающий сообщения сервера.
    public class SocketThread extends Thread {

        public void run() {
            try {
                 connection = new Connection(new Socket(getServerAddress(), getServerPort()));
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        //метод будет представлять клиента серверу.
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                MessageType messageType = connection.receive().getType();
                if (messageType == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (messageType == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else if (messageType != MessageType.NAME_REQUEST || messageType != MessageType.NAME_ACCEPTED) {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        //        Этот метод будет реализовывать главный цикл обработки сообщений сервера.
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else if (message.getType() != MessageType.TEXT || message.getType() != MessageType.USER_ADDED
                        || message.getType() != MessageType.USER_REMOVED) {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        //        должен выводить текст message в консоль
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        //  должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату.
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName);
        }

        //   должен выводить в консоль, что участник с именем userName покинул чат.
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName);
        }

        // а) Устанавливать значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
//б) Оповещать (пробуждать ожидающий) основной поток класса Client.
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }
    }


    protected Connection connection;


    //    В дальнейшем оно будет устанавливаться в true, если клиент подсоединен к серверу или в false в противном случае.
    private volatile boolean clientConnected = false;

    //   должен запросить ввод адреса сервера у пользователя и вернуть введенное значение.
    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    //   должен запрашивать ввод порта сервера и возвращать его
    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    //   должен запрашивать и возвращать имя пользователя
    protected String getUserName() throws IOException, ClassNotFoundException {
        return ConsoleHelper.readString();
    }

    // в данной реализации клиента всегда должен возвращать true (мы всегда/отправляем текст введенный в консоль).
// Этот метод может быть переопределен, если мы будем писать какой-нибудь другой клиент, унаследованный от нашего,
// который не должен отправлять введенный в консоль текст.
    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    //    должен создавать и возвращать новый объект класса SocketThread.
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    //    создает новое текстовое сообщение, используя переданный текст и отправляетего серверу через соединение connection.
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
//            clientConnected = true;
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("Ошибка при отправке сообщения на сервер");
        }
    }

    //    run(). Он должен создавать вспомогательный поток SocketThread, ожидать пока тот установит соединение с сервером, а
// после этого в цикле считывать сообщения с консоли и отправлять их серверу. Условием выхода из цикла будет отключение
// клиента или ввод пользователем команды 'exit'. Для информирования главного потока, что соединение установлено во
//вспомогательном потоке, используй методы wait и notify объекта класса Client.
    public void run() {
        Thread newSocketThread = getSocketThread();
        newSocketThread.setDaemon(true);
        newSocketThread.start();

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error! Socket thread is interrupted!");
            }
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        while (clientConnected) {
            String readText = ConsoleHelper.readString();
            if (readText.equalsIgnoreCase("exit")) {
                clientConnected = false;
                break;
            }
            if (shouldSendTextFromConsole()) sendTextMessage(readText);
        }
    }


    public static void main(String[] args) {
        new Client().run();
    }
}

/*
 Добавь метод void run(). Он должен создавать вспомогательный поток SocketThread, ожидать пока тот установит соединение с
 сервером, а после этого в цикле считывать сообщения с консоли и отправлять их серверу. Условием выхода из цикла
  будет отключение клиента или ввод пользователем команды 'exit'.
Для информирования главного потока, что соединение установлено во
вспомогательном потоке, используй методы wait и notify объекта класса Client.

Реализация метода run должна:
а) Создавать новый сокетный поток с помощью метода getSocketThread.
б) Помечать созданный поток как daemon, это нужно для того, чтобы при выходе из программы вспомогательный поток
 прервался автоматически.
в) Запустить вспомогательный поток.
г) Заставить текущий поток ожидать, пока он не получит нотификацию из другого потока. Подсказка: используй wait и
 синхронизацию на уровне объекта. Если во время ожидания возникнет исключение, сообщи об этом пользователю и выйди из программы.
д) После того, как поток дождался нотификации, проверь значение clientConnected. Если оно true - выведи "Соединение
 установлено. Для выхода наберите команду 'exit'.". Если оно false - выведи "Произошла ошибка во время работы клиента.".
е) Считывай сообщения с консоли пока клиент подключен. Если будет введена команда 'exit', то выйди из цикла.
ж) После каждого считывания, если метод shouldSendTextFromConsole() возвращает true, отправь считанный текст с помощью метода
sendTextMessage().

2. Добавь метод main(). Он должен создавать новый объект типа Client и вызывать у него метод run().

Требования:
1. Метод main должен создавать новый объект типа Client и вызывать у него метод run.
2. Метод run должен создавать запускать новый поток, полученный с помощью метода getSocketThread.
3. Поток созданный с помощью метода getSocketThread должен быть отмечен как демон (setDaemon(true)).
4. После запуска нового socketThread метод run должен ожидать до тех пор, пока не будет пробужден.
5. До тех пор, пока флаг clientConnected равен true,с консоли должны считываться сообщения с помощью метода
 ConsoleHelper.readString.
6. Если была введена команда "exit" цикл считывания сообщений должен быть прерван.
7. Если метод shouldSentTextFromConsole возвращает true, должен быть вызван метод sendTextMessage со считанным
 текстом в качестве параметра.
* */