package com.javarush.task.task18.task1818;

/* 
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.

1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file_1 = new FileOutputStream(reader.readLine());
        FileInputStream file_2 = new FileInputStream(reader.readLine());
        FileInputStream file_3 = new FileInputStream(reader.readLine());

        while (file_2.available() > 0){
            file_1.write(file_2.read());
        }

        while (file_3.available() > 0){
            file_1.write(file_3.read());
        }
        file_1.close();
        file_2.close();
        file_3.close();
        reader.close();
    }
}
