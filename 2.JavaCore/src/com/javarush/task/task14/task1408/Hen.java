package com.javarush.task.task14.task1408;

/**
 * Created by Нияз on 24.04.2018.
 */
abstract class Hen extends Solution.HenFactory implements Country {
    abstract int getCountOfEggsPerMonth();


    String getDescription() {
        return "Я - курица.";
    }
}