package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
5. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
6. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Ханнанов1", "Нияз");
        map.put("Ханнанова1", "Лэйла");
        map.put("Ханна1нов", "Илфар");
        map.put("Ханнан1ова", "Равиля");
        map.put("Ханнано1в", "Артур");
        map.put("Валиулли1н", "Ильдар");
        map.put("Ва1лиуллин", "Рахим");
        map.put("Вал1иуллина", "Лилия");
        map.put("Вали1уллина", "Камила");
        map.put("Валиу1ллина", "Альфия");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int i = 0;
        for (String val : map.values()) {
            if (name==val){
                i++;
            }
        }
        return i;
        //напишите тут ваш код
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int i =0;
        for (String key : map.keySet()) {
            if (map.containsKey(lastName)){
                i=1;
            }
        }
        return i;
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
