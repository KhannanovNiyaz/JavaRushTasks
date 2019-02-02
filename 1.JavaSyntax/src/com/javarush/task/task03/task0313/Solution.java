package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String[] mam = {"Мама" , "Мыла" , "Раму"};
        for (int i = 0 ; i < mam.length ; i++)
            for (int g = 0 ; g < mam.length; g++)
                for ( int f = 0; f < mam.length; f++)
                    if (i != g && i != f && g != f)
                        System.out.println(mam[i] + mam[g] + mam[f]);
    }
}

