package com.javarush.task.task19.task1914;

/* 
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9

Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "3 + 6 = ".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c
параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом printSomething()
 согласно заданию, и выводить её в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(outputStream);
        System.setOut(myStream);

        testString.printSomething();
        String s = outputStream.toString();
        String[] result = s.split(" ");
        System.setOut(consoleStream);

        int a = Integer.parseInt(result[0]);
        int b = Integer.parseInt(result[2]);
        int res = 0;

        switch (result[1]){
            case  "+": res = a+b; break;
            case  "-": res = a-b; break;
            case  "*": res = a*b; break;
            case  "/": res = a/b; break;
        }

        System.out.println(s + res);

//        byte[] resultNumber = result.getBytes();

//        for (int i = 0; i < resultNumber.length; i++) {
//            if ((char)resultNumber[i] != (char) 32){
//                System.out.println((char) resultNumber[i]);
//                ch += (char)resultNumber[i];
//                System.out.println(ch);
//            }
//
//        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

