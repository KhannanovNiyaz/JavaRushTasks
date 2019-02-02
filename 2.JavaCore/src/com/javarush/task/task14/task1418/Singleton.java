package com.javarush.task.task14.task1418;

/**
 * Created by Нияз on 26.04.2018.
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
