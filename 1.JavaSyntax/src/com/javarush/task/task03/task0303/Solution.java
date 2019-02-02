package com.javarush.task.task03.task0303;

/* 
Реализуй метод convertEurToUsd, переводящий евро в доллары по заданному курсу.
Вызови его дважды в методе main с любыми параметрами.
Результаты выведи на экран, каждый раз с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(5, 3.2));
        System.out.println(convertEurToUsd(15, 3.8));
        //напишите тут ваш код
    }

    public static double convertEurToUsd(int eur, double course) {
        return eur*course;
        //напишите тут ваш код
    }
}
