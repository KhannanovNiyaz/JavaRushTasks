package com.javarush.task.task18.task1828;

/* 
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
c:/file_1.txt
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        //        args = new String[]{"-u", "19847983", "123456789 123456789 1234567890", "12345678", "1234"};
//        args = new String[]{"-u", "19847983", "123456789012345678901234567890", "12345678", "1234"};
//        args = new String[]{"-d", "19847983"};
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
//            String fileName = "d:\\_JavaRush\\_Test\\task18.task1827.txt ";
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                List<String> list = new LinkedList<>();
                while ((line = fileReader.readLine()) != null) {
                    if (line.substring(0, 8).trim().equals(args[1])) {
                        if ("-u".equals(args[0])) {
                            list.add(String.format("%-8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4]));
                        }
                    } else {
                        list.add(line);
                    }
                }
                try (FileOutputStream fos = new FileOutputStream(fileName)) {
                    for (String s : list) {
                        fos.write((String.format("%s%n", s)).getBytes());
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
