package com.javarush.task.task20.task2025;

import java.util.Arrays;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        String number = String.valueOf(N);
        long[] result = new long[number.length()];
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < number.length(); i++) {
            int z = Character.getNumericValue(number.charAt(i));
//            buffer.append(Math.pow(z, number.length()));
            buffer.append((int)Math.pow(z, number.length()) + ",");
        }

//        System.out.println(buffer.toString());

        String[] res = buffer.toString().split(",");
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
//            sum += Long.parseLong(res[i]);
            sum += Integer.parseInt(res[i]);
        }
//        System.out.println(sum);

        String[] split = String.valueOf(sum).split("");

//        String[] s = new StringBuffer(sum).toString().split("");


        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNumbers(370)));
        System.out.println(Arrays.toString(getNumbers(8208)));
    }
}
/*
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
* */
