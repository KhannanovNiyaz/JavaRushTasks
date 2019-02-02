package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {

    @Override
    protected void initDishes() {
        this.dishes = new ArrayList<>();
        int countOfOrder = 1 + (int)(Math.random() * ((Dish.values().length - 1) + 1));
        for (int i = 0; i < countOfOrder ; i++) {
            int dish = (int) (Math.random() * Dish.values().length);
            dishes.add(Dish.values()[dish]);
        }
    }

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }
}


