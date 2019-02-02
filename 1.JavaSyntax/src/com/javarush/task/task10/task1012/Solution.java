package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        LinkedHashMap<Character, Integer> treeMap = new LinkedHashMap<>();
        for (Character characterAlphabet : alphabet) {
            treeMap.put(characterAlphabet, 0);
        }
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            for (String stringValue : list) {
                for (int i = 0; i < stringValue.length(); i++) {
                    if (entry.getKey().equals(stringValue.charAt(i))) {
                        entry.setValue(entry.getValue() + 1);
                    }
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

//        for (Map.Entry<Character, Integer> treeMap : treeMap.entrySet()) {
//            for (String stringValue : list) {
//                for (int i = 0; i <stringValue.length() ; i++) {
//                    if (treeMap.getKey().equals(stringValue.charAt(i))){
//                        treeMap.setValue(treeMap.getValue() + 1);
//                    }
//                }
//            }
//        }


        // напишите тут ваш код
    }

}
