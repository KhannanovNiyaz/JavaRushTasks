package com.javarush.task.task17.task1720;

/*
1. Класс BankAccount должен содержать private поле balance типа BigDecimal.
2. Метод deposit(String money) класса BankAccount должен делегировать поведение в метод deposit(BigDecimal money).
3. Метод withdraw(String money) класса BankAccount должен делегировать поведение в метод withdraw(BigDecimal money).
4. В методе withdraw(BigDecimal money), если необходимо, используй synchronized.
5. В методе deposit(BigDecimal money), если необходимо, используй synchronized.*/

public class NotEnoughMoneyException extends Exception {
}
