package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Arrays;

/* 
1. вводит с консоли число N, которое должно быть больше 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum;

        int numberCount = Integer.parseInt(reader.readLine());
        int[] array = new int[numberCount];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(array);
        maximum = array[numberCount-1];

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
