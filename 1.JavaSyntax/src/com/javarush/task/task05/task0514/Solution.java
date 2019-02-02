package com.javarush.task.task05.task0514;

/*
Добавь метод initialize(String name, int age), в котором проинициализируй переменные name и age.
В методе main создай объект Person, занеси его ссылку в переменную person.
Вызови метод initialize с любыми значениями.

4. У класса Person должен быть метод initialize, принимающий в качестве параметра имя, возраст и
инициализирующий соответствующие переменные класса.
5. Необходимо создать объект типа Person.
6. Необходимо вызвать метод initialize у созданного объекта и передать в него какие-либо параметры.
*/

public class Solution {
    public static void main(String[] args) {
        Person person = new Person();
        person.initialize("Niyaz", 27);
        //напишите тут ваш код
    }

    static class Person {
        String name;
        int age;

        public void initialize(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}
