package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //    для вывода message в консоль
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    //    для чтения строки с консоли
    public static String readString() throws IOException {
        return reader.readLine();
    }

    //    просит пользователя выбрать блюдо и добавляет его в список.
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> tempDish = new ArrayList<>();
        String selectedDish;
        do {
            writeMessage(Dish.allDishesToString());
            System.out.println("Выберите блюдо: ");
            if ((selectedDish = readString()).toLowerCase().equals("exit")) break;
            try {
                tempDish.add(Dish.valueOf(selectedDish));
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Указанного блюда в меню нет");
            }
        } while (!selectedDish.equals("exit"));
        return tempDish;
    }
}
