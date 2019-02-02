package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Restaurant;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable /*implements Observer */ {
    private String name;
    private boolean busy;  //метка занят/свободен повар
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = Restaurant.getOrderQueue();
    }

    public boolean isBusy() {
        return busy;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }

    public void startCookingOrder(Order order) {
        busy = true;
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %smin", order,
                order.getTotalCookingTime()));
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(
                order.getTablet().toString(),
                name,
                order.getTotalCookingTime() * 60,
                order.getDishes()
        ));
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
        }
        setChanged();
        notifyObservers(order);
        busy = false;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep( 10 );
            }
            catch (InterruptedException e) {}
            if (queue.peek()!=null) {
                if (!this.isBusy()) {
                    try {
                        Order order = queue.take();
                        if (order != null) {
                            startCookingOrder( order );
                        }
                    }
                    catch (InterruptedException e) {
                    }
                }
            }

//            for (Cook cook : cooks) {
//                if (!cook.isBusy()) {
//                    if (!orderQueue.isEmpty()) {
//                        Order order = orderQueue.poll();
//                        if (order != null)
//                            cook.startCookingOrder(order);
//                    }
//                }
//                if (orderQueue.isEmpty())
//                    break;
//            }
//            try {
//                Thread.sleep(10);
//            }
//            catch (InterruptedException e) {}
        }
    }
}

//    @Override
//    public void update(Observable observable, Object newOrderByTablet) {
//        Order order = (Order) newOrderByTablet;
//        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %smin", newOrderByTablet,
//                order.getTotalCookingTime()));
//        StatisticManager.getInstance().register(new CookedOrderEventDataRow(
//                observable.toString(),
//                this.name,
//                ((Order) newOrderByTablet).getTotalCookingTime() * 60,
//                ((Order) newOrderByTablet).getDishes()
//        ));
//        setChanged();
//        notifyObservers(newOrderByTablet);
//    }

/*
8. Сделай класс Cook - таском (Runnable). Перенеси логику из трэда внутри конструктора OrderManager в метод run класса Cook.
* */