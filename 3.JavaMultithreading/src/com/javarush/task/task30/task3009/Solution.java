package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
Объяви и реализуй логику приватного статического метода Set<Integer> getRadix(String number), в котором нужно
 определить, в каких системах счисления (от 2 до 36 включительно) представление числа number (передается в
 десятичной системе счисления) является палиндромом и добавить индекс таких систем в результат.
Если переданное число некорректно - возвращай пустой HashSet.
В системах счисления с основанием большим 10 в качестве цифр используются латинские буквы. К примеру, числу
35 в десятичной системе соответствует число "Z" в системе с основанием 36.

P.S.: В методе getRadix перехватывай NumberFormatException. Стек-трейс выводить не нужно.

Требования:
1. Необходимо объявить приватный статический метод Set<Integer> getRadix(String number).
2. Метод getRadix в случае некорректных входных данных должен возвращать пустой HashSet.
3. Методе getRadix не должен бросать NumberFormatException.
4. Метод getRadix не должен ничего выводить в консоль.
5. Метод getRadix должен возвращать множество согласно условию задачи.
*/

public class Solution {
    private static Set<Integer> getRadix(String number) {
        HashSet<Integer> set = new HashSet<>();
        StringBuffer temp;
        int numberIndex = 0;
        try {
            numberIndex = Integer.parseInt(number);
            for (int i = 2; i < 37; i++) {
                {
                    temp = new StringBuffer(Integer.toString(numberIndex, i));
                    if (temp.toString().equals(temp.reverse().toString())) {
                        set.add(i);
                    }
                }
            }
        } catch (NumberFormatException e) {
        }

        return set;
    }

    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }
}