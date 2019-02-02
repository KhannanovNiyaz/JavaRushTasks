package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
В программе случайным образом генерируются два целых числа A и В. Нужно вывести все целые числа от A до B включительно,
в порядке возрастания, если A меньше B, или в порядке убывания в противном случае.

Задача реализована с использованием рекурсии.
Иногда в результате работы программы получаем Exception in thread "main" java.lang.StackOverflowError.

Твоя задача: перепиши код без использования рекурсии.
Метод getAllNumbersBetween переименуй на getAllNumbersBetween.

Требования:
1. Метод getAllNumbersBetween необходимо переименовать на getAllNumbersBetween.
2. Ни в одном методе класса Solution не должно быть рекурсивных вызовов.
3. В конце строчки вывода последовательности чисел не должно быть пробела.
4. Логика работы программы должна остаться прежней.

   public static String getAllNumbersBetween(int a, int b) {
        if (a > b) {
            return a + " " + getAllNumbersBetween(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + getAllNumbersBetween(a + 1, b);
        }
    }
*/

public class Solution {
    private static int numberA;
    private static int numberB;

//    public static String getAllNumbersBetween(int a, int b) {
//        if (a > b) {
//            return a + " " + getAllNumbersBetween(a - 1, b);
//        } else {
//            if (a == b) {
//                return Integer.toString(a);
//            }
//            return a + " " + getAllNumbersBetween(a + 1, b);
//        }
//    }

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder stringBuffer = new StringBuilder();
        if (a > b) {
//            stringBuffer.append(a);
            while (a >= b) {
                stringBuffer.append((a--) + " ");
            }
        } else {
//            stringBuffer.append(a);
            while (a <= b) {
                stringBuffer.append((a++) + " ");
            }
        }
        return stringBuffer.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(100);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}