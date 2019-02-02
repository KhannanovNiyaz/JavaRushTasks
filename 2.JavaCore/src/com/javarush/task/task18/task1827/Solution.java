package com.javarush.task.task18.task1827;

/* 
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя
максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.
c:/result.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        BufferedReader fileReader = null;
        BufferedWriter fileWriter = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            fileReader = new BufferedReader(new FileReader(fileName));
            fileWriter = new BufferedWriter(new FileWriter(fileName, true));

            if (args[0].equals("-c")) {
                String productName = args[1];
//                String productName = args[1].substring(0, 30);
                String price = args[2];
//                String price = args[2].substring(0, 8);
                String quantity = args[3];
//                String quantity = args[3].substring(0, 4);

                String existDate;
                int maxID = 0;
                while ((existDate = fileReader.readLine()) != null) {
//                    String[] dataArray = existDate.split(" ");
                    int id = Integer.parseInt(existDate.substring(0, 8).trim());
                    if (id > maxID) maxID = id;
                }
                fileWriter.write(String.format("%n%-8d%-30s%-8s%-4s", maxID + 1, productName, price,quantity));
//                fileWriter.write("\r\n" + (maxID + 1) + productName + price + quantity);
            }

        } catch (IOException e) {
           /*NOP*/
        } catch (ArrayIndexOutOfBoundsException e) {
           /*NOP*/
        } finally {
            reader.close();
            fileReader.close();
            fileWriter.close();
        }
    }
}
