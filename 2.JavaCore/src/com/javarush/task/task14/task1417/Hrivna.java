package com.javarush.task.task14.task1417;

/**
 * Created by Нияз on 26.04.2018.
 */
public class Hrivna extends Money {

    @Override
    public String getCurrencyName() {
        return "HRN";
    }

    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }
}
