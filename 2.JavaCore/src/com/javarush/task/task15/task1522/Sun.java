package com.javarush.task.task15.task1522;

/**
 1. Класс Sun не должен позволять создавать объекты своего типа извне класса.
 2. Класс Sun должен содержать приватное статическое поле instance типа Sun.
 3. В классе Sun должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
 4. Метод getInstance в классе Sun должен ВСЕГДА возвращать один и тот же объект.
 5. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
 */
class Sun implements Planet {
    private static Sun instance;
    private Sun() {
    }

    public static synchronized Sun getInstance() {
        if (instance == null){
            return instance = new Sun();
        } return instance;
    }
}
