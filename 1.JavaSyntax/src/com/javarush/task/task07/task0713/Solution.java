package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.

1. Объяви и сразу проинициализируй 4 переменных типа ArrayList (список целых чисел). Первый список будет главным, а остальные - дополнительными.
2. Считать 20 чисел с клавиатуры и добавить их в главный список.
3. Добавить в первый дополнительный список все числа из главного, которые нацело делятся на 3.
4. Добавить во второй дополнительный список все числа из главного, которые нацело делятся на 2.
5. Добавить в третий дополнительный список все остальные числа из главного.
6. Метод printList должен выводить на экран все элементы переданного списка, каждый с новой строки.
7. Программа должна вывести три дополнительных списка, используя метод printList.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(); //четные
        ArrayList<Integer> list3 = new ArrayList<>();  // делятся на 3
        ArrayList<Integer> list4 = new ArrayList<>();  // все остальные

        for (int i = 0; i < 20; i++) {
            list1.add(new Scanner(System.in).nextInt());
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) % 3 == 0) {
                list2.add(list1.get(i));
            }
            if (list1.get(i) % 2 == 0) {
                list3.add(list1.get(i));
            }
            if (list1.get(i) % 2 != 0 && list1.get(i) % 3 != 0) {
                list4.add(list1.get(i));
            }
        }

        Solution.printList(list3);
        Solution.printList(list2);
        Solution.printList(list4);
        //напишите тут ваш код
    }

    public static void printList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
        //напишите тут ваш код
    }
}
