package com.javarush.task.task01.task0107;

/* 
Комментарии излишни
*/

public class Solution {
    public static void main(String[] args) {
        int x = 2;
        int y = 12;

       // x = x * 3;
        y = x + y;   //y = 14
        x = y - x;   //x = 12
        y = y - x;

        System.out.println(x);
        System.out.println(y);
    }
}
