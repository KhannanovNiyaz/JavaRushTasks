package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings =  new ArrayList<String>();
        int maxSize = 0;

        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            strings.add(s);
            if (s.length() >= maxSize){
                maxSize = s.length();
            }
        }

        for (int i = 0; i < 5; i++) {
            if (maxSize == strings.get(i).length()){
                System.out.println(strings.get(i));
            }
        }



//        String maxSize = "";


//        for (String s : strings) {
//            if (s.length() >= maxSize.length()){
//                maxSize = s;
//            }
//        }
//
//        ArrayList<String> arrayOfMaxSize = new ArrayList<>();
//        for (String s : strings) {
//            if (maxSize.length() <= s.length()){
//                arrayOfMaxSize.add(maxSize);
//            }
//        }
//
//        for (String s : arrayOfMaxSize) {
//            System.out.println(s);
//        }
    }
}
