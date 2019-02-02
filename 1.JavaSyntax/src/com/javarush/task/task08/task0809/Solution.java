package com.javarush.task.task08.task0809;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
Время для 10 тысяч вставок
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getTimeMsOfInsert(new ArrayList()));
        System.out.println(getTimeMsOfInsert(new LinkedList()));
    }

    public static long getTimeMsOfInsert(List list) {
        Date startTime = new Date();
        //напишите тут ваш код

        insert10000(list);
        Date endTime = new Date();

        //напишите тут ваш код
        return endTime.getTime() - startTime.getTime();

    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(0, new Object());
        }
    }
}
