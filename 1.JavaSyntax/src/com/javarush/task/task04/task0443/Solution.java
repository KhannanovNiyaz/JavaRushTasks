package com.javarush.task.task04.task0443;


/* 
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.

Вывести на экран текст:
"Меня зовут name.
Я родился d.m.y"
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();

        int date = Integer.parseInt(reader.readLine());
        int month = Integer.parseInt(reader.readLine());
        int year = Integer.parseInt(reader.readLine());

        System.out.println("Меня зовут " + name + ".");
        System.out.println("Я родился "+ year + "." + month + "." + date);
        //напишите тут ваш код
    }
}
