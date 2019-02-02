package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static LinkedBlockingQueue<Order> getOrderQueue() {
        return orderQueue;
    }

    public static void main(String[] args) throws ParseException {
        List<Tablet> tabletList = new ArrayList<>();
        Stream.iterate(1, i -> i + 1).limit(5).forEach(i -> tabletList.add(new Tablet(i)));
//        Tablet tablet_1 = new Tablet(1);
//        Tablet tablet_2 = new Tablet(2);
//        Tablet tablet_3 = new Tablet(3);
//        Tablet tablet_4 = new Tablet(4);
//        Tablet tablet_5 = new Tablet(5);

        Cook cook_1 = new Cook("Amigo");
        Cook cook_2 = new Cook("Liza");
        StatisticManager manager = StatisticManager.getInstance();
//        manager.register(cook_1);
//        manager.register(cook_2);
//        OrderManager orderManager = new OrderManager();

//        tabletList.stream().forEach(tablet -> tablet.addObserver(orderManager));
//        tablet_1.addObserver(cook_2);
//        tablet_2.addObserver(cook_2);
//        tablet_3.addObserver(cook_2);
//        tablet_4.addObserver(cook_2);
//        tablet_5.addObserver(cook_2);

        Thread newTask = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        newTask.start();

//        Tablet tablet_1 = new Tablet(1);
//        Cook cook_1 = new Cook("Amigo");
//        Waiter waiter_1 = new Waiter();
//        tablet_1.addObserver(cook_1);
//        cook_1.addObserver(waiter_1);
//        DirectorTablet directorTablet = new DirectorTablet();
//        tablet_1.createOrder();
//        tablet_1.createOrder();
//        tablet_1.createOrder();
//        tablet_1.createOrder();
//        directorTablet.printAdvertisementProfit();
//        directorTablet.printCookWorkloading();
//        directorTablet.printActiveVideoSet();
//        directorTablet.printArchivedVideoSet();
    }
}

/*

 * */
