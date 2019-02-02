package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char ar[] = s.toCharArray();

        ar[0] = Character.toUpperCase(ar[0]);
        for (int i = 0; i < ar.length; i++) {
            if (ar[i]== ' '){
                ar[i+1] = Character.toUpperCase(ar[i+1]);
            }
        }
        System.out.println(ar);


//        String array[] = s.split(" ", s.length());
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//        for (int i = 0; i < array.length ; i++) {
//            array[i] = array[i].substring(0, 1).toUpperCase() +array[i].substring(1);
//        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]);
//            if (i != array.length-1){
//                System.out.print(" ");
//            }
//        }

        //напишите тут ваш код
    }
}
