package com.javarush.task.task22.task2203;

/* 
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.

Требования:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть
 исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            String[] s = string.split("\t");
            if (s.length < 3) throw new TooShortStringException();
            return s[1];
        } catch (NullPointerException e) {
            throw new TooShortStringException();
        } catch (Exception ex) {
            throw new TooShortStringException();
        }
    }

//    public static String getPartOfString(String string) throws TooShortStringException {
//        if (string == null) throw new TooShortStringException();
//        String[] tmp = string.split("\t");
//        if (tmp.length < 3) throw new TooShortStringException();
//        return tmp[1];
//    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
