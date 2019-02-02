package com.javarush.task.task04.task0432;



/* 
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while. Каждое значение с новой строки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int i = Integer.parseInt(reader.readLine());

        while (i>0){
            System.out.println(s);
            i--;
        }
        //напишите тут ваш код

    }
}
