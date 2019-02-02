package com.javarush.task.task09.task0920;

/* 
Написать в цикле обратный отсчёт от 10 до 0. Для задержки использовать Thread.sleep(100);
Обернуть вызов sleep в try..catch.
Требования:
1. Программа должна выводить отсчет от 10 до 0.
2. Программа должна выводить на экран новое число каждые 100 миллисекунд.
3. Программа должна использовать метод "Thread.sleep(100);".
4. Метод main должен содержать блок try..catch.
5. Метод main не должен кидать исключений.
*/

public class Solution {
    public static void main(String[] args) {
        try {
            for (int i = 10; i >= 0; i--) {
                System.out.println(i);

                Thread.sleep(100);
                //напишите тут ваш код
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
