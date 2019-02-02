package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        for (int i = 0; i < s.length() ; i++) {
            int z = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (z %2 ==0) even++;
            else odd++;
        }



//        String sa = reader.readLine();
//        int a = Integer.parseInt(sa);
//
//        for (int i = 0; i < sa.length(); i++) {
//            if (a % 2 == 0) even ++;
//            else if (a % 2 != 0) odd ++;
//
//            a /= 10;
//        }
//
       System.out.println("Even: " + even + " " + "Odd: " + odd);
    }
}
