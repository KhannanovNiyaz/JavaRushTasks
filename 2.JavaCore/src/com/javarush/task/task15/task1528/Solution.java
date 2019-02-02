package com.javarush.task.task15.task1528;

/* 
Исправь класс Hrivna так, чтоб избежать возникновения ошибки StackOverflowError.

1. Класс Hrivna должен быть потомком класса Money.
2. В классе Hrivna должен быть реализован метод getAmount.
3. Метод getAmount в классе Hrivna должен возвращать значение поля amount.
4. В процессе выполнения программы НЕ должны возникать исключения или ошибки.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Hrivna().getAmount());
    }

    public static abstract class Money {
        abstract Money getMoney();

        public Object getAmount() {
            return getMoney().getAmount();
        }
    }

    //add your code below - добавь код ниже
    public static class Hrivna extends Money {
        public double amount = 123d;

        @Override
        public Object getAmount() {
            return amount;
        }

        public Hrivna getMoney() {
            return this;

        }
    }
}
