package com.javarush.task.task02.task0216;

/* 
Минимум трёх чисел
*/
public class Solution {
    public static int min(int a, int b, int c) {
       int min = 0;
        if(a<=b && a<=c) {
            min = a;
        } else  if(b<=a && b<=c) {
            min = b;
        } else if(c<=a && c<=b) {
            min = c;
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(10, 5, 10));
    }

}