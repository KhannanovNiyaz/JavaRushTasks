package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        int i = 2;
        while (i <= n) {
            if ((n % i) == 0) {
                if (i == n) {
                    System.out.println(i);
                } else {
                    System.out.println(i + " ");
                    recursion(n / i);
                }
                return;
            }
            i++;
        }
    }
}
