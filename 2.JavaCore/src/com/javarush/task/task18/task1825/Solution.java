package com.javarush.task.task18.task1825;

/*
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.

1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> OriginalNameList = new ArrayList<>();
        //  ArrayList<String> ModifyNameList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("end")) {
                OriginalNameList.add(fileName);
        }
        Collections.sort(OriginalNameList);

//        for (String s : OriginalNameList) {
//            if (s.endsWith(".partN")) {
//                ModifyNameList.add(s.replaceAll(".partN", ""));
//            }
//        }
        int lenghtName = OriginalNameList.get(0).lastIndexOf(".");
        String finalName = OriginalNameList.get(0).substring(0, lenghtName);
      //  String finalName = OriginalNameList.get(0).replaceAll(".partN", "");
        BufferedOutputStream oS = new BufferedOutputStream(new FileOutputStream(finalName, true));
        byte[] buffer = new byte[1024];
        for (String s : OriginalNameList) {
            BufferedInputStream iS = new BufferedInputStream(new FileInputStream(s));
            while (iS.available() > 0) {
                int count = iS.read(buffer);
                oS.write(buffer, 0, count);
            }
            iS.close();
        }
        oS.close();
    }
}
