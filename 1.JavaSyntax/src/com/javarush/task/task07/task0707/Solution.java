package com.javarush.task.task07.task0707;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("f");

        System.out.println(list.size());

        for (String s : list) {
            System.out.println(s);
        }
        //напишите тут ваш код
    }
}
