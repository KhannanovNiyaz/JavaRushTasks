package com.javarush.task.task19.task1920;

/*
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
c:/result.txt
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("c:/result.txt"))) {
            TreeMap<String, Double> map = new TreeMap<>();
            String s;
            while ((s = reader.readLine()) != null) {
                String[] buffer = s.split(" ");
                if (map.containsKey(buffer[0])) {
                    map.put(buffer[0], map.get(buffer[0]) + Double.parseDouble(buffer[1]));
                } else {
                    map.put(buffer[0], Double.parseDouble(buffer[1]));
                }
            }
            Collection<Double> list = map.values();
            double d = Collections.max(list);

            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue().equals(d)){
                    System.out.println(entry.getKey());
                }
            }

        } catch (IOException e) {
            /*NOP*/
        }
    }
}
