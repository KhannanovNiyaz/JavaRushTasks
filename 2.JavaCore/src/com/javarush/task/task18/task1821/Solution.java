package com.javarush.task.task18.task1821;

/* 
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361

1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer, Integer> symbol = new TreeMap<>();
        FileInputStream is = new FileInputStream(args[0]);

        while (is.available()>0){
            int data = is.read();
            if (!symbol.containsKey(data)){
                symbol.put(data, 1);
            } else {
                symbol.put(data, symbol.get(data)+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : symbol.entrySet()) {
            System.out.println(
                    (char) Integer.parseInt(entry.getKey().toString()) + " "
                            + entry.getValue());
        }
        is.close();
    }
}
