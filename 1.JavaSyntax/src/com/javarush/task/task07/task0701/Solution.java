package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        int[] arrayInit = new int[20];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrayInit.length; i++) {
            arrayInit[i] = scanner.nextInt();

        }
        // создай и заполни массив
        return arrayInit;
    }

    public static int max(int[] array) {
        int maxArray = array[0];
        for (int i : array) {
            if (i > maxArray) maxArray = i;
        }
        // найди максимальное значение
        return maxArray;
    }
}
