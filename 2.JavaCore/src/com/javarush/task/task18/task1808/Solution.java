package com.javarush.task.task18.task1808;

/* 
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.

1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file_1 = new FileInputStream(reader.readLine());
        FileOutputStream file_2 = new FileOutputStream(reader.readLine());
        FileOutputStream file_3 = new FileOutputStream(reader.readLine());

        int file_1Lenght = file_1.available();
        int partSize = file_1Lenght % 2 == 0 ? file_1Lenght / 2 : file_1Lenght / 2 + 1;

        while (file_1.available() > 0) {
            byte[] part1 = new byte[partSize];
            byte[] part2 = new byte[file_1Lenght - partSize];

            file_1.read(part1);
            file_1.read(part2);

            file_2.write(part1);
            file_3.write(part2);
        }

        file_1.close();
        file_2.close();
        file_3.close();
    }
}
