package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet /*extends Observable*/ {
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    // создает тестовый заказ
    public void createTestOrder() {
        TestOrder newOrder;
        try {
            newOrder = new TestOrder(this);
            creatAllOrder(newOrder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            newOrder = null;
        }
    }

    //    создает заказ
    public Order createOrder() {
        Order newOrder;
        try {
            newOrder = new Order(this);
            creatAllOrder(newOrder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            newOrder = null;
        }
        return newOrder;
    }


    private void creatAllOrder(Order newOrder) {
        if (!newOrder.isEmpty()) {
            ConsoleHelper.writeMessage(newOrder.toString());
//            setChanged();
//            notifyObservers(newOrder);
            queue.offer(newOrder);
            AdvertisementManager advertisementManager = new AdvertisementManager(newOrder.getTotalCookingTime() * 60);
            try {
                advertisementManager.processVideos(); //вызов просмотра видео
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + newOrder);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);
    }
}

