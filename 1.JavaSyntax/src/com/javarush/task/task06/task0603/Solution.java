package com.javarush.task.task06.task0603;

/* 
Создать в цикле по 50 000 объектов Cat и Dog.
(Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется).
*/

public class Solution {
    public static void main(String[] args) {

        for (int i = 0; i <50000 ; i++) {
            Cat cat = new Cat();
            Dog dog = new Dog();
        }
        //напишите тут ваш код
    }
}

class Cat {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
