package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (!thread.isInterrupted()){
            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {
//            e.printStackTrace();
            }
            while (true){
                try {
                    ShareItem take = queue.take();
                    System.out.format("Processing " + take.toString() + System.lineSeparator());
                } catch (InterruptedException e) {
//                e.printStackTrace();
                }
            }
        }
    }
}

