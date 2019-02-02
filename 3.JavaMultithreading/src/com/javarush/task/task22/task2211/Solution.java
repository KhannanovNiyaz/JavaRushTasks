package com.javarush.task.task22.task2211;

import java.io.*;

/* 
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.

Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[0]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[1])) {
            byte[] buffer = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                fileInputStream.read(buffer);
                String s = new String(buffer, "Windows-1251");
                buffer = s.getBytes("UTF-8");
                fileOutputStream.write(buffer);
            }
        } catch (IOException e) {
            /*NOP*/
        }
    }
}
