package com.javarush.task.task14.task1421;

/**
 * Created by Нияз on 26.04.2018.
 */
public final class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
