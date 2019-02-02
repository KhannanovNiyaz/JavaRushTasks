package com.javarush.task.task14.task1408;

/**
 * Created by Нияз on 24.04.2018.
 */
class RussianHen extends Hen implements Country {
    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA +
                ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
