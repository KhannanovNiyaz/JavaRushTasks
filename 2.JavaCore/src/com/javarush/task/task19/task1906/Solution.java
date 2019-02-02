package com.javarush.task.task19.task1906;

/* 
Четные символы  c:/data.txt
c:/result.txt
c:/file_1.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(reader.readLine());
             FileWriter fileWriter = new FileWriter(reader.readLine())) {

            int count = 0;
            int c;
            while ((c = fileReader.read()) != -1) {
                if (++count % 2 == 0) {
                    fileWriter.write(c);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
