package com.javarush.task.task18.task1802;

/*
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.

1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int minValue = inputStream.read();
        while (inputStream.available() >0){
            int currentValue = inputStream.read();
            if (minValue > currentValue){
                minValue = currentValue;
            }
        }
        inputStream.close();
        System.out.println(minValue);

    }
}
