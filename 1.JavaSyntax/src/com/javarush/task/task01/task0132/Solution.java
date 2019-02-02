package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int sum = 0;
        String s = Integer.toString(number);
        for (int i = 0; i < s.length(); i++) {
            sum = sum + Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;//напишите тут ваш код
    }
}