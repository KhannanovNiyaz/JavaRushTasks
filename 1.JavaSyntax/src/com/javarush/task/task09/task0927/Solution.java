package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.

1. Программа не должна считывать данные с клавиатуры.
2. Метод createMap должен создавать новый объект HashMap.
3. Метод createMap должен добавлять в словарь 10 котов в виде «Имя»-«Кот».
4. Метод createMap должен возвращать созданный словарь.
5. Метод convertMapToSet должен создать и вернуть множество котов, полученных из переданного словаря.
6. Программа должна вывести всех котов из множества на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        HashMap<String, Cat> cat = new HashMap<>();
        cat.put("Имя1", new Cat("Кот1"));
        cat.put("Имя2", new Cat("Кот2"));
        cat.put("Имя3", new Cat("Кот3"));
        cat.put("Имя4", new Cat("Кот4"));
        cat.put("Имя5", new Cat("Кот5"));
        cat.put("Имя6", new Cat("Кот6"));
        cat.put("Имя7", new Cat("Кот7"));
        cat.put("Имя8", new Cat("Кот8"));
        cat.put("Имя9", new Cat("Кот9"));
        cat.put("Имя10", new Cat("Кот0"));
        return cat;
        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        HashSet<Cat> catValue = new HashSet<Cat>();
        //catValue.addAll(map)
        //напишите тут ваш код

        for (Cat cat : map.values()) {
            catValue.add(cat);
        }
        return catValue;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
