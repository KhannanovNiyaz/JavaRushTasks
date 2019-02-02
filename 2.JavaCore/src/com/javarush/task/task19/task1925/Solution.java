package com.javarush.task.task19.task1925;

/* 
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура

Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
c:\result.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
       try(BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWritee = new BufferedWriter(new FileWriter(args[1]))){
           StringBuilder sb = new StringBuilder();
           String readFileString;
          // String line = "";
           while ((readFileString = fileReader.readLine()) != null){
               String[] buf = readFileString.split(" ");
               for (int i = 0; i < buf.length; i++) {
                   if (buf[i].length() >6 && sb.length()==0){
                       sb.append(buf[i]);
//                       line = line.concat(buf[i]);
                   } else if (buf[i].length() >6 && sb.length()!=0){
                       sb.append(",".concat(buf[i]));
//                       line = line.concat(",".concat(buf[i]));
                   }
               }
           }
           fileWritee.write(sb.toString());
//           fileWritee.write(line.concat(System.lineSeparator()));
       }catch (IOException e){
            /*NOP*/
       }
    }
}
