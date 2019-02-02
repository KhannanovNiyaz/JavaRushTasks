package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {
    @Override
    public void update(Observable order, Object newOrderByCook) {
        ConsoleHelper.writeMessage(String.format("%s was cooked by %s", newOrderByCook, order.toString()));
    }
}
