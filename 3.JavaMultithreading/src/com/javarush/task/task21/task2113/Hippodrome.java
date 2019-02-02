package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
Добавим определение победителя.
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!

Пример:
Winner is Lucky!

Требования:
1. В классе Hippodrome должен быть создан метод getWinner без параметров.
2. В классе Hippodrome должен быть создан метод printWinner без параметров.
3. Метод getWinner должен возвращать лошадь пробежавшую наибольшую дистанцию.
4. Метод printWinner должен выводить на экран имя победителя на экран в формате заданном в условии задачи.
*/
public class Hippodrome {
    static Hippodrome game;

    Horse getWinner(){
        TreeMap<Double, Horse> map = new TreeMap<>();
        for (Horse hors : horses) {
            map.put(hors.distance, hors);
        }
        return map.lastEntry().getValue();
    }

    void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    void run() throws InterruptedException {
        for (int i = 1; i < 101; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    void move() {
        for (Horse hors : horses) {
            hors.move();
        }
    }

    void print() {
        for (Horse hors : horses) {
            hors.print();
        }
        for (int i = 0; i <10; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Hippodrome.game = new Hippodrome(new ArrayList<>());
        Horse horse_1 = new Horse("Horse_1", 3, 0);
        Horse horse_2 = new Horse("Horse_3", 3, 0);
        Horse horse_3 = new Horse("Horse_3", 3, 0);
        Hippodrome.game.getHorses().add(horse_1);
        Hippodrome.game.getHorses().add(horse_2);
        Hippodrome.game.getHorses().add(horse_3);

        game.run();

        game.printWinner();
    }
}
