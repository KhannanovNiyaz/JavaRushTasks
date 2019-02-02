package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int minSize=0;

        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            list.add(s);
            minSize = list.get(0).length();
            if (s.length() < minSize) {
                minSize = s.length();
            }
        }

        for (int i = 0; i < 5; i++) {
            if (minSize == list.get(i).length()) {
                System.out.println(list.get(i));
            }
        }

        //напишите тут ваш код
    }
}
