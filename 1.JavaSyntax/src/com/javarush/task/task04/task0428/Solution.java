package com.javarush.task.task04.task0428;

/* 
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int [] mus = new int[3];

        for (int i = 0; i < mus.length; i++) {
            mus[i] = Integer.parseInt(reader.readLine());

        }

        for (int x : mus) {
            if (x>0) count++;
        }

        System.out.println(count);
        //напишите тут ваш код

    }
}
