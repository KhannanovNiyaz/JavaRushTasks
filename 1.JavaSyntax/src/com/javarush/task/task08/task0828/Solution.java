package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> months = new HashMap<>();
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String requireMonth = reader.readLine();

        for (Map.Entry<String, Integer> entry : months.entrySet()) {
            if (requireMonth.equals(entry.getKey())){
                System.out.println(entry.getKey() + " is " + entry.getValue() + " month");
            }
        }
        //напишите тут ваш код
    }
}
