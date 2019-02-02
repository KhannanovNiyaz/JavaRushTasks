package com.javarush.task.task10.task1001;

/* 
Метод main() должен содержать переменную a типа int.
4. Метод main() должен содержать переменную b типа int.
5. Метод main() должен содержать переменную c типа byte.
6. Метод main() должен содержать переменную f типа double.
7. Метод main() должен содержать переменную d типа long.
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        int b =  a + 46;
        byte c = (byte) (a * b);
        double f = 1234.15;
        long d = (long) (a + f / c + b);
        System.out.println(d);
    }
}
