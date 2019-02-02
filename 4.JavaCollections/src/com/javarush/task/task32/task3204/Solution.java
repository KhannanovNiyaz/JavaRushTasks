package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
????????? ???????
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        String laters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "1234567890";
        StringBuffer passw = new StringBuffer();

        for (int i = 0; i <4; i++) {
            passw.append(digits.charAt((int) (Math.random()*10)));
        }
        for (int i = 0; i < 2; i++) {
            passw.append(laters.charAt((int) (Math.random()*26)));
        }
        for (int i = 0; i < 2; i++) {
            passw.append(laters.toUpperCase().charAt((int) (Math.random()*26)));
        }

        output.write(passw.toString().getBytes());

       return output;
//        StringBuffer stringBuffer = new StringBuffer();
//        int randomNuber = 0;
//        for (int i = 0; i < 8; i++) {
////            stringBuffer.append((char) (48 + (Math.random() * 57)));
////            stringBuffer.append((char) (65 + (Math.random() * 90)));
////            stringBuffer.append((char) (97 + (Math.random() * 122)));
//            randomNuber = (int) (1 + (Math.random() * 3));
//            stringBuffer.append(generateSymbol(randomNuber));
//        }
//        stringBuffer.setLength(8);
//
//        System.out.println(stringBuffer.length());
//        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
//        arrayOutputStream.write(stringBuffer.toString().getBytes());
//
//        return arrayOutputStream;
    }

//    private static StringBuffer generateSymbol(int num) {
//        StringBuffer buffer = new StringBuffer();
//        String s;
//        switch (num) {
//            case 1:
//                buffer.append((char) (48 + (Math.random() * 57)));
//                System.out.println((char) (48 + (Math.random() * 57)));
//                break;
//            case 2:
//                buffer.append((char) (65 + (Math.random() * 90)));
//                System.out.println((char) (65 + (Math.random() * 90)));
//                break;
//            case 3:
//                buffer.append((char) (97 + (Math.random() * 122)));
//                System.out.println((char) (97 + (Math.random() * 122)));
//                break;
//        }
//        s = buffer.toString();
//        System.out.println(s);
//        return buffer;
//    }
}

/*
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
* */

