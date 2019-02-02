package com.javarush.task.task18.task1816;

/* 
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.

1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream myReadFile = new FileInputStream(args[0]);
        int countOfLetters = 0;

        while (myReadFile.available() >0){
            int readByte = myReadFile.read();
            if (readByte >= 65 && readByte <=90 || readByte >= 97 &&readByte <=122){
                countOfLetters++;
            }
        }

        System.out.println(countOfLetters);

        myReadFile.close();

    }
}
