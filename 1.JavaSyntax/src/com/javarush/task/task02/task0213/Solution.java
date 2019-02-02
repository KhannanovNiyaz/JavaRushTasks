package com.javarush.task.task02.task0213;

/* 
Питомцам нужны люди
*/
public class Solution {
    public static void main(String[] args) {
     Cat cat = new Cat();
     Dog dog = new Dog();
     Fish fish = new Fish();
     Woman lena = new Woman();
     cat.owner = lena;
     dog.owner = lena;
     fish.owner = lena;
        //напишите тут ваш код
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
