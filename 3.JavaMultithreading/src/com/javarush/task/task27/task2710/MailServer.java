package com.javarush.task.task27.task2710;

//Thread-0 MailServer has got: [Person [Thread-1] has written an email 'AAA'] in 1001 ms after start
public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long beforeTime = System.currentTimeMillis();
        synchronized (mail) {
            while (mail.getText() == null) {
                try {
                    mail.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //сделайте что-то тут - do something here
            String name = Thread.currentThread().getName();
            long afterTime = System.currentTimeMillis();
            System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
            notifyAll();
        }
    }
}
