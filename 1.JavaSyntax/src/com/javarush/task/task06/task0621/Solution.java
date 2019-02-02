package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача: У каждой кошки есть имя и кошка-мама.
Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму.
Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама.
Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку (папин папа), бабушку (мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

1. Программа должна считывать имена 6 котов в указанном порядке.
2. Метод main должен создавать 6 объектов типа Cat.
3. Программа должна выводить 6 строк с информацией о котах.
4. Строка про дедушку (первая) должна соответствовать условию.
5. Строка про бабушку (вторая) должна соответствовать условию.
6. Строка про папу (третья) должна соответствовать условию.
7. Строка про маму (четвертая) должна соответствовать условию.
8. Строка про сына (пятая) должна соответствовать условию.
9. Строка про дочь (шестая) должна соответствовать условию.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Cat grandFater = new Cat(reader.readLine(), null, null);
        Cat grandMother = new Cat(reader.readLine(), null, null);

        Cat father = new Cat(reader.readLine(), null, grandFater);
        Cat mother = new Cat(reader.readLine(), grandMother, null);

        Cat son = new Cat(reader.readLine(), mother, father);
        Cat dother = new Cat(reader.readLine(), mother, father);

        System.out.println(grandFater);
        System.out.println(grandMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(dother);

//        String motherName = reader.readLine();
//        Cat catMother = new Cat(motherName);
//
//        String daughterName = reader.readLine();
//        Cat catDaughter = new Cat(daughterName, catMother);
//
//        System.out.println(catMother);
//        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;

        }

        @Override
        public String toString() {
            if (mother == null && father == null) {
                return "Cat name is " + name + ", no mother " + ", no father";
            } else if (mother != null && father == null) {
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
            } else if (mother == null && father != null) {
                return "Cat name is " + name + ", no mother " + ", father is " + father.name;
            } else return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }
}


