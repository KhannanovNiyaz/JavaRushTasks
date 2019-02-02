package com.javarush.task.task08.task0813;

import java.util.Set;
import java.util.HashSet;

/* 
Создать множество строк (Set<String>), занести в него 20 слов на букву "Л".

4. Метод createSet() должен создавать и возвращать множество (реализация HashSet).
5. Множество из метода createSet() должно содержать 20 слов на букву «Л».
*/

public class Solution {
    public static Set<String> createSet() {
        HashSet<String> hashSet = new HashSet<>();
        String s = "Л";
        for (int i = 0; i < 20; i++) {
            hashSet.add(s + 'a' + i);

        }

        return hashSet;

        //напишите тут ваш код

    }

    public static void main(String[] args) {


    }
}
