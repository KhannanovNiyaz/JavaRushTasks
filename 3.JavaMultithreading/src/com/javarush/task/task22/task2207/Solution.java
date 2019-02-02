package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
        Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
        Использовать StringBuilder.
        Кодировка файла - UTF-8.

        Пример содержимого файла
        рот тор торт о
        о тот тот тот

        Вывод:
        рот тор
        о о
        тот тот


        Требования:
        1. Метод main должен считывать имя файла с клавиатуры.
        2. В методе main должен быть использован StringBuilder.
        3. В классе Solution должен содержаться вложенный класс Pair.
        4. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
        5. Список result должен быть заполнен корректными парами согласно условию задачи.
        c:/file_1.txt
        c:/Users/Нияз/IdeaProjects/Test/src/file_2.txt
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder sb = new StringBuilder();

        while (fileReader.ready()) {
            sb.append(fileReader.readLine()).append(" ");
        }

        String[] words = sb.toString().split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
        boolean canDelete = false;

        for (int i = 0; i < list.size();) {
            sb.delete(0, sb.length());
            sb.append(list.get(i)).reverse();
            for (int j = 1; j < list.size(); j++) {
                if (sb.toString().equals(list.get(j))) {
                    Pair pair = new Pair();
                    pair.first = list.get(i);
                    pair.second = sb.toString();
                    if (!result.toString().contains(pair.toString())) {
                        result.add(pair);
                        list.remove(list.get(i));
                        list.remove(list.indexOf(sb.toString()));
                        canDelete = false;
                        break;
                    }
                }
                canDelete = true;
            }
            if (canDelete) list.remove(list.get(i));
            if (list.size() <= 1) break;
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
