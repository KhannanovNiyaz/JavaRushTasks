package com.javarush.task.task04.task0424;

/* 
Ввод с клавиатуры, сравнение чисел и вывод на экран - у студентов 4 уровня секретного центра JavaRush
 эти навыки оттачиваются до автоматизма.
Давайте напишем программу, в которой пользователь вводит три числа с клавиатуры. Затем происходит сравнение,
и если мы находим число, которое отличается от двух других, выводим на экран его порядковый номер.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] mus = new int[3];

        for (int i = 0; i < mus.length; i++) {
            mus[i] = Integer.parseInt(reader.readLine());
        }

        if (mus[0] == mus[1] && mus[0] != mus[2]) System.out.println(3);
        if (mus[0] == mus[2] && mus[0] != mus[1]) System.out.println(2);
        if (mus[2] == mus[1] && mus[0] != mus[2]) System.out.println(1);

        //напишите тут ваш код
    }
}
