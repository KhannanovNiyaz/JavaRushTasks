package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые
есть в forRemoveLines
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.

Требования:
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться
 все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не
содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader firstFileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader secondFileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            String dataFirsFile;
            String dataSecondFile;
            while ((dataFirsFile = firstFileReader.readLine()) != null) {
                allLines.add(dataFirsFile);
            }
            while ((dataSecondFile = secondFileReader.readLine()) != null) {
                forRemoveLines.add(dataSecondFile);
            }
            new Solution().joinData();
        } catch (CorruptedDataException ce) {
           /*NOP*/
        } catch (IOException e) {
           /*NOP*/
        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
