package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую

3/5 = 3; 6/5 =1; 8/5 = 3 зелен
4/5 = 4; 9/5 = 4; 14/5 = 4 желт
5/5=0; 10/5 = 0 красн

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(reader.readLine());
        if (a%5 < 3) {
            System.out.println("зеленый");
        }else if (a%5 < 4){
            System.out.println("желтый");
        }else System.out.println("красный");
        //напишите тут ваш код
    }
}