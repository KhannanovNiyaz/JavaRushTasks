package com.javarush.task.task17.task1707;

/*
Singleton паттерн - синхронизация в методе.
Класс IMF - это Международный Валютный Фонд.
Внутри метода getFund создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте поле imf так, чтобы метод getFund всегда возвращал один и тот же объект.

1. Класс IMF должен содержать приватное статическое поле IMF imf.
2. Класс IMF должен содержать приватный конструктор.
3. Класс IMF должен содержать публичный статический метод IMF getFund().
4. Метод getFund() должен содержать синхронизированный блок.
5. Внутри синхронизированного блока должно быть проинициализировано поле imf.
6. Метод getFund() должен всегда возвращать один и тот же объект.
*/

public class IMF {

    private static IMF imf;

    public static IMF getFund() {
        synchronized (IMF.class){
            if (imf == null) {
                imf = new IMF();
            } else return imf;
        }
        //add your code here - добавь код тут
        return imf;
    }

    private IMF() {
    }
}
