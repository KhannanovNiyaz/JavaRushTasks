package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
Сейчас будем реализовывать класс BotSocketThread, вернее переопределять некоторые его методы, весь основной функционал
он уже унаследовал от SocketThread.

1. Переопредели метод clientMainLoop():
а) С помощью метода sendTextMessage() отправь сообщение с текстом "Привет чатику. Я бот. Понимаю команды: дата, день,
 месяц, год, время, час, минуты, секунды."
б) Вызови реализацию clientMainLoop() родительского класса.
2. Переопредели метод processIncomingMessage(String message). Он должен следующим образом обрабатывать входящие сообщения:
а) Вывести в консоль текст полученного сообщения message.
б) Получить из message имя отправителя и текст сообщения. Они разделены ": ".
в) Отправить ответ в зависимости от текста принятого сообщения.
Если текст сообщения:
"дата" - отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
"день" - в формате "d";
"месяц" - "MMMM";
"год" - "YYYY";
"время" - "H:mm:ss";
"час" - "H";
"минуты" - "m";
"секунды" - "s".
Указанный выше формат используй для создания объекта SimpleDateFormat. Для получения текущей даты необходимо использовать
 класс Calendar и метод getTime().
Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ, например, если Боб отправил запрос "время",
 мы должны отправить ответ "Информация для Боб: 12:30:47".
Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
Помни, что message бывают разных типов и не всегда содержат ":"

Требования:
1. Метод clientMainLoop класса BotSocketThread должен вызывать метод sendTextMessage у внешнего объекта BotClient c
 приветственным сообщением указанном в условии задачи.
2. Метод clientMainLoop класса BotSocketThread должен вызывать clientMainLoop у объекта родительского класса (super).
3. Метод processIncomingMessage должен выводить на экран полученное сообщение message.
4. Метод processIncomingMessage должен отправлять ответ с помощью метода sendTextMessage (форматирование согласно условию задачи).
5. Метод processIncomingMessage не должен вызывать метод sendTextMessage для некорректных запросов.
 * */
public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
//            super.processIncomingMessage(message);
            ConsoleHelper.writeMessage(message);
            if (message.contains(":") && !message.isEmpty()){
//                String name = message.substring(0, message.indexOf(":"));
//                String text = message.replaceAll(name + ": ", "");
                String mess[] = message.split(": ");
                String name = mess[0];
                String text = mess[1];

                Map<String, String> mapDate = new HashMap<>();
                mapDate.put("дата", "d.MM.YYYY");
                mapDate.put("день", "d");
                mapDate.put("месяц", "MMMM");
                mapDate.put("год", "YYYY");
                mapDate.put("время", "H:mm:ss");
                mapDate.put("час", "H");
                mapDate.put("минуты", "m");
                mapDate.put("секунды", "s");

                Date date = Calendar.getInstance().getTime();
                SimpleDateFormat simpleDateFormat;
                if (mapDate.containsKey(text)){
                    simpleDateFormat = new SimpleDateFormat(mapDate.get(text));
                    sendTextMessage(String.format("Информация для %s: %s", name, simpleDateFormat.format(date)));
                }

            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    @Override
    protected String getUserName() throws IOException, ClassNotFoundException {
        return "date_bot_" + ((int) (Math.random() * 100));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}

/*
1) Создай новый класс BotClient в пакете client. Он должен быть унаследован от Client.
2) В классе BotClient создай внутренний класс BotSocketThread унаследованный от SocketThread. Класс BotSocketThread
 должен быть публичным.
3) Переопредели методы:
а) getSocketThread(). Он должен создавать и возвращать объект класса BotSocketThread.
б) shouldSendTextFromConsole(). Он должен всегда возвращать false. Мы не хотим, чтобы бот отправлял текст введенный в консоль.
в) getUserName(), метод должен генерировать новое имя бота, например: date_bot_X, где X - любое число от 0 до 99.
Для генерации X используй метод Math.random().
4) Добавь метод main. Он должен создавать новый объект BotClient и вызывать у него метод run().


Требования:
1. В пакете client должен быть создан класс BotClient являющийся потомком класса Client.
2. В классе BotClient должен быть создан внутренний публичный класс BotSocketThread являющийся потомком класса SocketThread.
3. В классе BotClient должен быть переопределен метод getSocketThread возвращающий новый объект класса BotSocketThread.
4. В классе BotClient должен быть переопределен метод shouldSendTextFromConsole всегда возвращающий false.
5. В классе BotClient должен быть переопределен метод getUserName возвращающий имя бота по формату указанному в условии задачи.
6. В методе main класса BotClient должен быть создан новый объект класса BotClient и у него должен быть вызван метод run.
* */