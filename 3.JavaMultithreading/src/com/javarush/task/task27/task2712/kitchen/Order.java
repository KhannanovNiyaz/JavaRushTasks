package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    //    Метод isEmpty в классе Order должен возвращать true, если заказ пуст.
    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    //    посчитать продолжительность приготовления всего заказа.
    public int getTotalCookingTime() {
        int fullTimeCooking = 0;
        for (Dish dish : dishes) {
            fullTimeCooking += dish.getDuration();
        }
        return fullTimeCooking;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();

    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : String.format("Your order: %s of %s", dishes, tablet);
    }
}

//    В классе Order должен быть создан метод initDishes инициализирующий dishes.

