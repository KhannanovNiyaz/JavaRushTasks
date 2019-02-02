package com.javarush.task.task19.task1908;

/* 
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1

Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла
(используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
c:\result.txt
c:\file_2.txt
c:\file_1.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileInputReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter fileOutWriter = new BufferedWriter(new FileWriter(reader.readLine())))
        {
            String s;
            Integer number;
            while ((s = fileInputReader.readLine()) != null) {
                String[] digitsArray = s./*replaceAll("\\D", " ").*/split(" ");
                for (String s1 : digitsArray) {
                    if (s1.matches("\\d+")){
                        fileOutWriter.write(s1 + " ");
                    }
//                    try {
//                        number = Integer.parseInt(s1);
//                        fileOutWriter.write(number + " ");
//                    } catch (NumberFormatException e) {
//                  /*NOP*/
//                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

