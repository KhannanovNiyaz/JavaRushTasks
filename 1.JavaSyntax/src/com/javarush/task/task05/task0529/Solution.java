package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введет слово "сумма".
Вывести на экран полученную сумму.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int num;

        while (true) {
            String s = reader.readLine();
            if (!s.equals("сумма")) {
                num = Integer.parseInt(s);
                sum = sum + num;
            } else {
                System.out.println(sum);
                break;
            }
        }
        //напишите тут ваш код
    }
}
