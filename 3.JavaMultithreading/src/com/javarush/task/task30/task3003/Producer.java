package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (int i = 1; i < 10; i++) {
            if (thread.isInterrupted()){
                return;
            }
            System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
            queue.offer(new ShareItem("ShareItem-" + i, i));
            try {
                Thread.sleep(100);
                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!%n");
                }
            } catch (InterruptedException e) {
//            e.printStackTrace();
            }
        }
    }

    public void offer() {

    }
}


