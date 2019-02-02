package com.javarush.task.task10.task1013;

/* 
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String firstName;
        private String lastName;
        private String nationality;
        private char sex;
        private int age;
        private int growth;

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public Human(char sex) {
            this.sex = sex;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName, String lastName, String nationality) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.nationality = nationality;
        }

        public Human(String nationality, char sex) {
            this.nationality = nationality;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, String nationality, char sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.nationality = nationality;
            this.sex = sex;
        }

        public Human(String nationality, char sex, int age) {
            this.nationality = nationality;
            this.sex = sex;
            this.age = age;
        }

        public Human(String firstName, String lastName, String nationality, char sex, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.nationality = nationality;
            this.sex = sex;
            this.age = age;
        }

        public Human(String firstName, String lastName, String nationality, char sex, int age, int growth) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.nationality = nationality;
            this.sex = sex;
            this.age = age;
            this.growth = growth;
        }

        // напишите тут ваши переменные и конструкторы
    }
}
