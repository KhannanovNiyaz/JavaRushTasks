package com.javarush.task.task21.task2103;

/* 
Упростить. Переменные не переименовывать, комментарии не оставлять.

Требования:
1. Метод calculate должен быть статическим.
2. Метод calculate должен возвращать значение типа boolean.
3. Метод calculate должен принимать четыре параметра типа boolean.
4. Метод calculate должен быть максимально упрощен(поведение должно остаться прежним).
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
//        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);//
        return c ;//
    }

    public static void main(String[] args) {
        System.out.println(calculate(true, true, true, true));
        System.out.println(true && true && true && false);
        System.out.println(false && true);
        System.out.println(true && true);

        /*Когда гуглил данную тему, то встретил такое высказывание
        "Операцию И часто называют "логическим умножением",
        а ИЛИ "логическим сложением" - они ведут себя соответствующим образом. "
        Если это применить, то все становится более менее понятно :)

        abc!d + !ac + !bc + cd =
        c (ab*!d + !a + !b + d) =






        */

    }
}
