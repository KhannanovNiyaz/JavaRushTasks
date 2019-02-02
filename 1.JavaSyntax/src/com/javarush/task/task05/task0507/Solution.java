package com.javarush.task.task05.task0507;

/* 
Вводить с клавиатуры числа и вычислить среднее арифметическое.
Если пользователь ввел -1, вывести на экран среднее арифметическое всех чисел и завершить программу.
-1 не должно учитываться.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int number = Integer.parseInt(reader.readLine());
            if (number != -1){
                sum = sum + number;
                count++;
            } else if (number == -1){
                System.out.println((double) sum/count);
                break;
            }
        }
        //напишите тут ваш код
    }
}

