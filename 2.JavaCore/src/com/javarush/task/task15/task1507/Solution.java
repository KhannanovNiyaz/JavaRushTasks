package com.javarush.task.task15.task1507;

/* 
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.

1. В классе Solution должны быть реализованы 10 методов printMatrix с различными аргументами.
2. Класс Solution должен быть public.
3. Все методы класса Solution должны быть статическими.
4. Все методы класса Solution должны быть публичными.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Double m, int n, String value) {
        System.out.println("Заполняем  String");
        printMatrix(m, n,  value);
    }

    public static void printMatrix(int m, Integer n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (String) value);
    }

    public static void printMatrix(int m, char n, Integer value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n,  value);
    }

    public static void printMatrix(int m, int n, char value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n,  value);
    }

    public static void printMatrix(char m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n,  value);
    }

    public static void printMatrix(int m, Byte n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, (byte)n,  value);
    }

    public static void printMatrix(int m, int n, Double value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(char m, char n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
