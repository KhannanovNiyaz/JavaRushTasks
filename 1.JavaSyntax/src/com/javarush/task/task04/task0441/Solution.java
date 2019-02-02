package com.javarush.task.task04.task0441;


/* 
Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
Если все числа равны, вывести любое из них.
*/
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(array);
        System.out.println(array[1]);

        //напишите тут ваш код
    }
}
