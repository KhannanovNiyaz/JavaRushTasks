package com.javarush.task.task26.task2610;
/*
* Разберись с BlockingQueue.
По образу и подобию класса Producer создай класс Consumer, который будет выводить данные из BlockingQueue в консоль.


Требования:
1. Класс Consumer должен быть создан в отдельном файле.
2. Класс Consumer должен реализовывать интерфейс Runnable.
3. Класс Consumer должен содержать приватное поле BlockingQueue queue.
4. Класс Consumer должен содержать конструктор с одним параметром, инициализирующий поле queue.
5. Метод run() класса Consumer должен постоянно выводить на экран значения из очереди.*/

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue queue;

    Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(queue.remove());
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
