package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.

1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }

    }

    public static class ReadThread extends Thread {
        private String filename;

        public ReadThread(String fileName) throws FileNotFoundException {
            this.filename = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run() {

            try (FileInputStream fIS = new FileInputStream(filename)) {
                TreeMap<Integer, Integer> map = new TreeMap<>();
                int maxVal = 1;
                int maxKey = 0;
                while (fIS.available() > 0) {
                    int nextByte = fIS.read();
                    if (!map.containsKey(nextByte)) {
                        map.put(nextByte, 1);
                    } else {
                        int value = map.get(nextByte) + 1;
                        map.replace(nextByte, value);
                        if (value > maxVal) {
                            maxVal = value;
                            maxKey = nextByte;
                        }
                    }
                }
                resultMap.put(filename, maxKey);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
