package com.javarush.task.task15.task1527;

/*
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            List<String> values = new LinkedList<>();
            for (String line : reader.readLine().split("\\?")[1].split("&")) {
                String[] splitParams = line.split("=");
                if (splitParams[0].equals("obj")) {
                    values.add(splitParams[1]);
                }
                System.out.print(splitParams[0] + " ");
            }
            System.out.println();

            for (String value : values) {
                try {
                    alert(Double.parseDouble(value));
                } catch (NumberFormatException e) {
                    alert(value);
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
