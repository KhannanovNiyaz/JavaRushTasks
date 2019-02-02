package com.javarush.task.task18.task1803;

/*
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.

1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        while (inputStream.available() > 0) {
            int value = inputStream.read();
            Integer newVal = map.get(value);
            map.put(value, newVal == null? 1 : newVal+1);
//                if (map.containsKey(value)){
//                    map.put(value,  map.get(value)+1);
//                } else {
//                    map.put(value, 1);
//                }
        }
        
        int max = 0;
        for (Integer integer : map.values()) {
            if (integer> max) max = integer;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max)){
                System.out.print(entry.getKey() + " ");
            }
        }
        
        inputStream.close();

    }
}
