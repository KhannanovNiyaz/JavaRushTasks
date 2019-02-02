package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    if (i == a.length-1) {
                        if (j == a[0].length-1 || a[i][j + 1] == 0) {
                            count++;
                        }
                    } else if (j == a[0].length-1 || a[i][j + 1] == 0 && a[i + 1][j] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
//        int count = 0;
//        for (byte[] bytes : a) {
//            for (byte aByte : bytes) {
//                if (aByte == 1) {
//                    count++;
//                }
//            }
//        }return count;
    }
}
