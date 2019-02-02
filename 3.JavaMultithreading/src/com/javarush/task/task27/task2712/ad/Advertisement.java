package com.javarush.task.task27.task2712.ad;

//* 2. Создадим класс Advertisement(Рекламное объявление)

public class Advertisement {
    private Object content;             //видео
    String name;
    private long initialAmount;          //начальная сумма, стоимость рекламы в копейках
    private int hits;                   //количество оплаченных показов
    private int duration;               //продолжительность в секундах
    private long amountPerOneDisplaying;  //стоимость одного показа рекламного объявления в копейках (initialAmount/hits).

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    //Уменьшать количество показов или бросает исключение, если количество показов отрицательное число
    public void revalidate() throws NoVideoAvailableException {
        if (hits <= 0) throw new NoVideoAvailableException();
        else hits--;
    }

    public int getHits() {
        return hits;
    }
}

//2. В классе Advertisement создай геттеры для полей name, duration и amountPerOneDisplaying.