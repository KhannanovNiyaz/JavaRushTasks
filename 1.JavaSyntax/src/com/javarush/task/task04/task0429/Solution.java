package com.javarush.task.task04.task0429;

/* 
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и
количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б",
где а, б - искомые значения.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int countPosit = 0;
        int countNegativ = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int array[] = new int[3];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
            if (array[i] > 0) countPosit++;
            if (array[i]<0) countNegativ++;
        }

        System.out.println("количество отрицательных чисел: " + countNegativ);
        System.out.println("количество положительных чисел: " + countPosit);
        //напишите тут ваш код

    }
}
