package com.javarush.task.task18.task1819;

/* 
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.

1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_1_Name = reader.readLine();
        String file_2_Name = reader.readLine();


        InputStream file_1 = null;
        FileOutputStream file_1_out = null;
        FileInputStream file_2 = null;
        try {
            file_1 = new BufferedInputStream(new FileInputStream(file_1_Name));
            int count1 = file_1.available();
            byte[] byteFile = new byte[count1];
            file_1.read(byteFile);
            file_1_out = new FileOutputStream(file_1_Name, true);
            file_2 = new FileInputStream(file_2_Name);
            int count2 = file_2.available();
            byte[] byteFile2 = new byte[count2];
            file_2.read(byteFile2);
            file_1_out.write(byteFile2, 0, count2);
            file_1_out.write(byteFile, 0, count1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file_1.close();
            file_2.close();
            file_1_out.close();

        }


    }
}
