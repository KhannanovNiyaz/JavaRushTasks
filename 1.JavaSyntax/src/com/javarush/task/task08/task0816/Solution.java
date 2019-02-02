package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.time.Month;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("1Stallone", new Date("January 1 1980"));
        map.put("S2tallone", new Date("February 1 1943"));
        map.put("St3allone", new Date("March 1 2380"));
        map.put("Sta4llone", new Date("April 1 2980"));
        map.put("Stal5lone", new Date("May 1 3980"));
        map.put("Stall6one", new Date("JUNE 1 1999"));
        map.put("Stallo7ne", new Date("July 1 2900"));
        map.put("Stallon8e", new Date("August 1 2014"));
        map.put("Stallone9", new Date("September 1 1989"));
        map.put("Stallone0", new Date("October 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<HashMap.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, Date> pair = iterator.next();
            if (pair.getValue().getMonth() > 4 &&
                    pair.getValue().getMonth() < 8) {
                iterator.remove();

            }

            //напишите тут ваш код
        }
    }

    public static void main(String[] args) {

    }
}
