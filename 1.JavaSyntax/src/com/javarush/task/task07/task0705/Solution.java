package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] arrayBig = new int[20];
        int[] array1 = new int[10];
        int[] array2 = new int[10];

        for (int i = 0; i < arrayBig.length; i++) {
            arrayBig[i] = scanner.nextInt();
        }

        for (int i = 0; i < arrayBig.length; i++) {
            if (i < arrayBig.length / 2) {
                array1[i] = arrayBig[i];
            } else {
                array2[i -arrayBig.length/2] = arrayBig[i];
            }
        }

        for (int i : array2) {
            System.out.println(i);
        }
    }
}
