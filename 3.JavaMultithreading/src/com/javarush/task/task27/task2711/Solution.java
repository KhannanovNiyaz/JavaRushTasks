package com.javarush.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
Дана стандартная реализация методологии wait-notify.
Почитай про CountDownLatch и перепиши тело метода someMethod используя поле latch.
Весь лишний код удали из класса.

1. Из класса Solution должно быть удалено поле lock.
2. Из метода someMethod должен быть удален synchronized блок.
3. В методе someMethod должен быть вызван метод await без параметров у объекта сохраненного в поле latch.
4. В методе someMethod должен быть вызван метод retrieveValue.
5. В методе someMethod должен быть вызван метод countDown у объекта сохраненного в поле latch.
*/
public class Solution {
  //  private final Object lock = new Object();
    private volatile boolean isWaitingForValue = true;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {

            while (isWaitingForValue) {
               latch.await();

            retrieveValue();

            isWaitingForValue = false;
            latch.countDown();
        }
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) throws InterruptedException {
      Solution  s=  new Solution();
        s.retrieveValue();
        s.someMethod();
        s.someMethod();
    }
}
