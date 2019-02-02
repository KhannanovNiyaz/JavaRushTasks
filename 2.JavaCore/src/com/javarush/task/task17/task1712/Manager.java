package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/*
2. Класс Manager должен содержать очередь с заказами (private final поле orderQueue типа Queue).
3. Класс Manager должен содержать очередь с готовыми блюдами (private final поле dishesQueue типа Queue).
4. Класс Manager должен реализовывать паттерн Singleton.
5. Класс Waiter должен реализовывать интерфейс Runnable.
6. Класс Cook должен реализовывать интерфейс Runnable.
7. Если нет готовых блюд в очереди, нить класса Waiter должна получать заказ от столика и добавлять его в очередь заказов.
8. Если есть готовые блюда в очереди, нить класса Waiter должна брать блюдо из очереди и относить заказ для столика.
9. Если нет заказов в очереди с заказами, нить класса Cook должна отдыхать (повар отдыхает).
10. Если есть заказы в очереди с заказами, нить класса Cook должна готовить блюдо и добавлять его в очередь с готовыми блюдами.
*/
public class Manager {      //singleton
    private static  Manager ourInstance = new Manager();



    private final List<Table> restaurantTables = new ArrayList<Table>(10);
    private int currentIndex = 0;

    private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<Order>();        // очередь с заказами
    private final Queue<Dishes> dishesQueue = new ConcurrentLinkedQueue<Dishes>();     // очередь с готовыми блюдами

    public synchronized static Manager getInstance() {
        return ourInstance;
    }

    private Manager() {               // создаем 10 столов
        for (int i = 0; i < 10; i++) {
            restaurantTables.add(new Table());
        }
    }

    public synchronized Table getNextTable() {           // официант ходит по кругу от 1 стола к 10
        Table table = restaurantTables.get(currentIndex);
        currentIndex = (currentIndex + 1) % 10;
        return table;
    }

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    public Queue<Dishes> getDishesQueue() {
        return dishesQueue;
    }
}
