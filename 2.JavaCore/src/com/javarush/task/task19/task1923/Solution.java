package com.javarush.task.task19.task1923;

/* 
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1])))
        {
            String fileString;
            while ((fileString = fileReader.readLine()) != null){
                String[] stringBuffer = fileString.split(" ");
                for (String str : stringBuffer) {
                    if (str.matches("\\w+\\d+.*")) fileWriter.write(str.concat(" "));
                }
            }

        } catch (IOException e) {
            /*NOP*/
        }
    }
}
