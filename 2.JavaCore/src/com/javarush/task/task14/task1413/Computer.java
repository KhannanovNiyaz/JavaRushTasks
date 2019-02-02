package com.javarush.task.task14.task1413;

/**
 * 6. В класс Computer добавь приватное поле keyboard типа Keyboard.
 * 7. В класс Computer добавь приватное поле mouse типа Mouse.
 * 8. В класс Computer добавь приватное поле monitor типа Monitor.
 * 6. Конструктор класса Computer должен принимать 3 параметра(keyboard, mouse, monitor) и корректно инициализировать соответствующие
 * поля класса.
 * 11. Создай геттеры для полей класса Computer (в классе используй комбинацию клавиш Alt+Insert и выбери команду Getter).
 * Computer computer = new Computer(new Keyboard(), new Mouse(), new Monitor());
 */
public class Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
