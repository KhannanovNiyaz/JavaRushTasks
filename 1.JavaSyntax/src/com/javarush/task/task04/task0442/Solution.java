package com.javarush.task.task04.task0442;


/* 
Вводить с клавиатуры числа.
Если пользователь ввел -1, вывести на экран сумму всех введенных чисел и завершить программу.
-1 должно учитываться в сумме.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int sum = 0;

        while (num != -1){
            sum = sum + num;
            num = Integer.parseInt(reader.readLine());
        }

        System.out.println(sum + num);
        //напишите тут ваш код
    }
}
