package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static  {
        labels.put(456.6, "Qwed");
        labels.put(45326.6, "Qweds");
        labels.put(456332.6, "Qwesd");
        labels.put(45632.6, "Qwedcx");
        labels.put(456.546, "Qwevd");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
