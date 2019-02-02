package com.javarush.task.task04.task0433;


/* 
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i = 10;
        while (i > 0){
            int j = 10;
            while (j>0){
                System.out.print("S");
                j--;
            }

            System.out.println();
            i--;
        }

        //напишите тут ваш код

    }
}
