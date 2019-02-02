package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
//        return Integer.highestOneBit(number);
        number |= number >> 1;
        number |= number >> 2;
        number |= number >> 3;
        number |= number >> 4;
        number |= number >> 5;
        number |= number >> 6;
        number |= number >> 7;
        number |= number >> 8;
        number |= number >> 8;
        number |= number >> 8;
        return number &~(number >> 1);
    }
}

/*
10000000 00000000 00000000 00000000
00000000 00000000 00000000 00000000

Параметр метода resetLowerBits может быть от 1 до Integer.MAX_VALUE включительно.
Используй только операции:
1) =
2) |
3) &
4) >>
5) <<
6) ~
7) цифры от 0 до 9 включительно
8) круглые скобки
9) оператор "return" для возврата результата метода.
* */