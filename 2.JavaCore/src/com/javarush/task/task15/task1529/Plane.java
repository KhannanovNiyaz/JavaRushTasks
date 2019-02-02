package com.javarush.task.task15.task1529;

/**
 * Created by Нияз on 05.05.2018.
 */
public class Plane implements Flyable {
    int numberOfPassengers;

    public Plane(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public void fly() {

    }
}
