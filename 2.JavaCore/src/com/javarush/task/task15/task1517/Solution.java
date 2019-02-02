package com.javarush.task.task15.task1517;

/* 
В статическом блоке выбросьте Exception
В результате класс не загрузится, и вы увидите сообщение об ошибке вместо значения переменной B
Требования:
1. В классе Solution в статическом блоке должно возникать исключение(Exception).
2. Программа не должна ничего выводить на экран(кроме автоматического сообщения о возникшем исключении).
3. Программа не должна считывать данные с клавиатуры.
4. Класс Solution должен быть public.
*/

public class Solution {
    public static int A = 0;

    static {
       A = A/0;
        //throw an exception here - выбросьте эксепшн тут
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
