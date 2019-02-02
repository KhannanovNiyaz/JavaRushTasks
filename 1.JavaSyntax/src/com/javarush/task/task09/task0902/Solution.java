package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getMethodName();
        //напишите тут ваш код
    }

    public static String method2() {
        method3();
        StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getMethodName();
        //напишите тут ваш код
    }

    public static String method3() {
        method4();
        StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getMethodName();
        //напишите тут ваш код
    }

    public static String method4() {
        method5();
        StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getMethodName();
        //напишите тут ваш код
    }

    public static String method5() {
        StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
       return stackTraceElement[2].getMethodName();
        //напишите тут ваш кодa
    }
}
