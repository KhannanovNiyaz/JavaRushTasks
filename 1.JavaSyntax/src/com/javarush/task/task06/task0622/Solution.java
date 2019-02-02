package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* 
1. Программа должна считывать 5 чисел с клавиатуры.
2. Программа должна выводить 5 чисел, каждое с новой строки.
3. Выведенные числа должны быть отсортированы по возрастанию.
4. Вывод должен содержать те же числа, что и были введены (порядок не важен).
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int array[] = new int[5];
        for (int i = 0; i < array.length ; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(array);

//        System.out.println(array.toString());

        for (int i : array) {
            System.out.println(i);
        }

        //напишите тут ваш код
    }
}
