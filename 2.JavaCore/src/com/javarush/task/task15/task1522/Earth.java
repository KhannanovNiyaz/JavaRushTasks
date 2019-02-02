package com.javarush.task.task15.task1522;

/**
 * Created by Нияз on 06.05.2018.
 */
class Earth implements Planet {
    private static Earth instance;

    private Earth() {
    }

    public static synchronized Earth getInstance() {
        if (instance == null){
            instance = new Earth();
        } return instance;
    }
}
