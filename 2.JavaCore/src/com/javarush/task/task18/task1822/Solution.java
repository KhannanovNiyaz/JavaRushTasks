package com.javarush.task.task18.task1822;

/* 
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.

Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file = bufferedReader.readLine();
        bufferedReader.close();
        ArrayList<String> list = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            for (String id : list) {
                if (id.startsWith(args[0] + " ")) {
                    System.out.println(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
