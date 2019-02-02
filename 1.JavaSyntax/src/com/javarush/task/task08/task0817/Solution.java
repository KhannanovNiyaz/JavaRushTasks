package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.

4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей.
5. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
6. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Ханнанов", "Нияз");
        hashMap.put("1Ханнанов", "Нияз1");
        hashMap.put("Х2аннанов", "Ния1з");
        hashMap.put("Ха3ннанов", "Нияз1");
        hashMap.put("Хан4нанов", "Нияз");
        hashMap.put("Ханн5анов", "Нияз2");
        hashMap.put("Ханна6нов", "Нияз2");
        hashMap.put("Ханнан7ов", "Нияз3");
        hashMap.put("Ханнано8в", "Ния2з");
        hashMap.put("Ханнанов9", "Ния3з");

        return hashMap;
        //напишите тут ваш код
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> entry : copy.entrySet()) {
            for (Map.Entry<String, String> maps : map.entrySet()) {
                if (entry.getValue().equals(maps.getValue()) && !entry.getKey().equals(maps.getKey())){
                    removeItemFromMapByValue(map, entry.getValue());
                    break;
                }
            }
        }

        //напишите тут ваш код

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
