package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:

2. Программа должна считывать значения с клавиатуры.
4. Программа должна вывести фамилию семьи по введенному городу.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
      //  List<String> addresses = new ArrayList<String>();
        HashMap<String, String> homeAdrresAndSity = new HashMap<>();

        while (true) {
            String family = reader.readLine();
            if (family.isEmpty()) break;

            String city = reader.readLine();
            if (city.isEmpty()) break;

            homeAdrresAndSity.put(family, city);
        }

        String foundCity = reader.readLine();

        for (Map.Entry<String, String> entry : homeAdrresAndSity.entrySet()) {
            if (foundCity.equals(entry.getKey())){
                System.out.println(entry.getValue());
            }
        }

        //read home number
      //  String houseNumberSity = Integer.parseInt(reader.readLine());
//
//        if (0 <= houseNumberSity && houseNumberSity < homeAdrresAndSity.size()) {
//            String familySecondName = homeAdrresAndSity.get(houseNumberSity);
//            System.out.println(familySecondName);
//        }
    }
}
