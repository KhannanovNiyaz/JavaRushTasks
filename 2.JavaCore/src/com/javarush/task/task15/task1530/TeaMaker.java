package com.javarush.task.task15.task1530;

/**
 6. Метод getRightCup в классе LatteMaker должен выводить на экран фразу "Берем чашку для латте".
 7. Метод putIngredient в классе LatteMaker должен выводить на экран фразу "Делаем кофе".
 8. Метод pour в классе LatteMaker должен выводить на экран фразу "Заливаем молоком с пенкой".
 9. Метод getRightCup в классе TeaMaker должен выводить на экран фразу "Берем чашку для чая".
 10. Метод putIngredient в классе TeaMaker должен выводить на экран фразу "Насыпаем чай".
 11. Метод pour в классе TeaMaker должен выводить на экран фразу "Заливаем кипятком".
 */
public class TeaMaker extends DrinkMaker {
    @Override
    void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    void pour() {
        System.out.println("Заливаем кипятком");
    }
}
