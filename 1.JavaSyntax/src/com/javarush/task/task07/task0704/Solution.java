package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Вывести на экран элементы массива в обратном порядке, каждое значение выводить с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[10];
        for (int i = 0; i < array.length ; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = array.length; i > 0; i--) {
            System.out.println(array[i-1]);

        }

        //напишите тут ваш код
    }
}

