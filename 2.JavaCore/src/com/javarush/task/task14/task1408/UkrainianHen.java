package com.javarush.task.task14.task1408;

/**
 * Created by Нияз on 24.04.2018.
 */
class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 5;
    }

    @Override
    String getDescription() {
        return super.getDescription()  + " Моя страна - " + Country.UKRAINE +
                ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
