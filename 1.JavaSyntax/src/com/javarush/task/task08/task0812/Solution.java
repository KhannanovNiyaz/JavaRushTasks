package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Cамая длинная последовательность 2, 4, 4, 4, 8, 8, 9, 12, 12, 14:
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            arrayList.add(scanner.nextInt());
        }

        int count = 1;
        int maxCount = 1;
        for (int i = 0; i < arrayList.size()-1; i++) {
            if (arrayList.get(i) == arrayList.get(i + 1)) {
                count++;
                if (maxCount <= count) {
                    maxCount = count;
                }
            }
            else {

                count = 1;
            }
        }

        System.out.println(maxCount);
        //напишите тут ваш код

    }
}