package com.javarush.task.task21.task2113;

public class Horse {

    public void move() {
        distance += Math.random() * speed;
    }

    public void print() {
        for (int i = 0; i < (int) getDistance(); i++) {
            System.out.print(".");
        }
        System.out.println(getName());
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    String name;
    double speed;
    double distance;
}
