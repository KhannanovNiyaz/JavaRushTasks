package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());

        int[] mus = {a,b,c,d};
        int  max = mus[0];
        for (int i = 1; i < mus.length; i++) {
            if (mus[i] > max){
                max = mus[i];
            }
        }
        System.out.println(max);


        //напишите тут ваш код
    }
}
