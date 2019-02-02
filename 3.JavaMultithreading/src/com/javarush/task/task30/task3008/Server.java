package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1) Server - основной класс сервера.
 * Приступим к самому важному - написанию класса Server. Сервер должен поддерживать
 * множество соединений с разными клиентами одновременно. Это можно реализовать с помощью следующего алгоритма:
 * - Сервер создает серверное сокетное соединение.
 * - В цикле ожидает, когда какой-то клиент подключится к сокету.
 * - Создает новый поток обработчик Handler, в котором будет происходить обмен
 * сообщениями с клиентом.
 * - Ожидает следующее соединение.
 * <p>
 * 2. Класс Handler должен реализовывать протокол общения с клиентом.
 */
public class Server {
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

 /*
1. Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода
getRemoteSocketAddress.
2. Создавать Connection, используя поле socket.
3. Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
4. Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED).
Подумай, какой метод подойдет для этого лучше всего.
5. Сообщать новому участнику о существующих участниках.
6. Запускать главный цикл обработки сообщений сервером.
7. Обеспечить закрытие соединения при возникновении исключения.
8. Отловить все исключения типа IOException и ClassNotFoundException, вывести в консоль информацию, что произошла
ошибка при обмене данными с удаленным адресом.

9. После того как все исключения обработаны, если п.11.3 отработал и возвратил нам имя, мы должны удалить запись
для этого имени из connectionMap и разослать всем остальным участникам сообщение с типом USER_REMOVED и сохраненным именем.
10. Последнее, что нужно сделать в методе run() - вывести сообщение, информирующее что соединение с удаленным адресом закрыто.

Наш сервер полностью готов. Попробуй его запустить.

1. Метод run должен выводить на экран сообщение о том, что было установлено соединение с удаленным адресом
(используя метод getRemoteSocketAddress).
2. Метод run должен создавать новое соединение (connection) используя в качестве параметра поле socket.
3. Метод run должен вызывать метод serverHandshake используя в качестве параметра только что созданное соединение;
результатом будет имя пользователя (userName).
4. Метод run должен вызывать метод sendBroadcastMessage используя в качестве параметра новое сообщение
 (MessageType.USER_ADDED, userName).
5. Метод run должен вызывать метод sendListOfUsers используя в качестве параметров connection и userName.
6. Метод run должен вызывать метод serverMainLoop используя в качестве параметров connection и userName.
7. Прежде чем завершиться, метод run должен удалять из connectionMap запись соответствующую userName, и
 отправлять всем участникам чата сообщение о том, что текущий пользователь был удален.
8. Метод run должен корректно обрабатывать исключения IOException и ClassNotFoundException.
 */

        /**
 Реализуем метод void run() - главный метод класса Handler, который будет вызывать вс вспомогательные методы, написанные ранее
         */

        public void run() {
            String newUserName = null;
            ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            try (Connection newConnection = new Connection(socket)) {
                newUserName = serverHandshake(newConnection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUserName));
                sendListOfUsers(newConnection, newUserName);
                serverMainLoop(newConnection, newUserName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            } finally {
                if (newUserName != null){
                    connectionMap.remove(newUserName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,newUserName));
                }
//                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUserName + " - пользователь был удален"));
                ConsoleHelper.writeMessage("Cоединение с удаленным адресом закрыто");
                // connectionMap.remove(newUserName,socket);

            }
        }

        /**
         * главный цикл обработки сообщений сервером.
         */
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message != null && message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }

            }
        }

        /**
         * протокол общения с клиентом.Выделим из протокола отдельные этапы и реализуем их с помощью отдельных методов:
         * Этап первый - это этап рукопожатия (знакомства сервера с клиентом)
         */
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message clientMessage = connection.receive();
                if (clientMessage.getType() == MessageType.USER_NAME) {
                    if (!clientMessage.getData().isEmpty()) {
                        if (!clientMessage.getData().equals("")) {
                            if (!connectionMap.containsKey(clientMessage.getData())) {
                                connectionMap.put(clientMessage.getData(), connection);
                                connection.send(new Message(MessageType.NAME_ACCEPTED));
                                return clientMessage.getData();
                            }
                        }
                    }
                }
            }
        }

        /**
         * отправка клиенту (новому участнику) информации об остальных клиентах (участниках) чата.
         */
        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!userName.equals(entry.getKey())) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }
    }


    static private Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("не удалось отправить сообщение");
            }
        }
    }


    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("сервер запущен");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Этап второй, но не менее важный - отправка клиенту (новому участнику) информации об
остальных клиентах (участниках) чата.

Для этого:
1) Добавь приватный метод void sendListOfUsers(Connection connection, String userName) throws IOException
, где connection - соединение с участником, которому будем слать информацию, а userName - его имя. Метод должен:
2) Пройтись по connectionMap.
3) У каждого элемента из п.2 получить имя клиента, сформировать команду с типом USER_ADDED и полученным именем.
4) Отправить сформированную команду через connection.
5) Команду с типом USER_ADDED и именем равным userName отправлять не нужно, пользователь и так имеет информацию о себе.

1. В классе Handler должен быть создан метод private void sendListOfUsers(Connection connection, String userName).
2. Метод sendListOfUsers должен отправлять через connection сообщение о том, что был добавлен пользователь с именем name
 для каждого имени из connectionMap.
3. Метод sendListOfUsers НЕ должен отправлять сообщение о добавлении пользователя, если имя пользователя совпадает
 со вторым параметром метода (userName).

* */
