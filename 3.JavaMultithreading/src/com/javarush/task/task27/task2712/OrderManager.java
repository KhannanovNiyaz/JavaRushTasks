//package com.javarush.task.task27.task2712;
//
//import com.javarush.task.task27.task2712.kitchen.Cook;
//import com.javarush.task.task27.task2712.kitchen.Order;
//import com.javarush.task.task27.task2712.statistic.StatisticManager;
//
//import java.util.Observable;
//import java.util.Observer;
//import java.util.Set;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class OrderManager implements Observer {
//    LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
//
//    @Override
//    public void update(Observable o, Object order) {
//        orderQueue.add((Order) order);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Set<Cook> cooks = StatisticManager.getInstance().getCooks();
//                while (true) {
//                    for (Cook cook : cooks) {
//                        if (!cook.isBusy()) {
//                            if (!orderQueue.isEmpty()) {
//                                Order order = orderQueue.poll();
//                                if (order != null)
//                                    cook.startCookingOrder(order);
//                            }
//                        }
//                        if (orderQueue.isEmpty())
//                            break;
//                    }
//                    try {
//                        Thread.sleep(10);
//                    }
//                    catch (InterruptedException e) {}
//                }
//            }
//        });
//        thread.setDaemon(true);
//        thread.start();
//    }
//}
//
///*
//* 5. В конструкторе OrderManager создай и запусти демон-трэд. Логика метода run:
//каждые 10 миллисекунд проверять очередь. Если в очереди есть заказы, то найти свободных поваров и передать
// им заказы (метод startCookingOrder), если нет свободных поваров или нет заказов в очереди, то ждать дальше.
//* */
//
