package com.javarush.task.task08.task0827;

import java.util.Calendar;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) {
        Date dateNow = new Date(date);
        Date secondDay = new Date();
        secondDay.setSeconds(0);
        secondDay.setMinutes(0);
        secondDay.setHours(0);
        secondDay.setDate(0);
        secondDay.setMonth(0);
        secondDay.setYear(dateNow.getYear());

        long msTimeDistanc = dateNow.getTime() - secondDay.getTime();
        long msDay = 60 * 60 * 24 * 1000;

        int day = (int) (msTimeDistanc / msDay +1);

        if (day % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
