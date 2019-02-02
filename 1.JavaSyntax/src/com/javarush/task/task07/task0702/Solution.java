package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/* 
1. Программа должна создавать массив на 10 строк.
2. Программа должна считывать 8 строк для массива с клавиатуры.
3. Программа должна выводить 10 строк, каждую с новой строки.
4. Все строки массива (10 элементов) должны быть выведены в обратном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String array[] = new String[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length - 2; i++) {
            array[i] = scanner.nextLine();
        }

        for (int i = 9; i >= 0; i--) {
            System.out.println(array[i]);

        }
        //напишите тут ваш код
    }
}