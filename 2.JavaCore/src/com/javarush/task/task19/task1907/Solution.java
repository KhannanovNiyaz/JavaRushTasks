package com.javarush.task.task19.task1907;

/* 
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.

Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
c:/result.txt
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            int count = 0;
            String s;
//           String [] array = s.replaceAll("\\W", " ").split(" ");
//           String [] array1 = s.replaceAll("\\W|\\d", " ").split(" ");
//            System.out.println(s);
//            System.out.println(Arrays.toString(array));
//            System.out.println(Arrays.toString(array1));
            while ((s = fileReader.readLine()) != null) {
                String[] array1 = s.replaceAll("\\W|\\d", " ").split(" ");
                // String[] array = s.split(" ");

                for (int i = 0; i < array1.length; i++) {
                    if (array1[i].equals("world")) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
