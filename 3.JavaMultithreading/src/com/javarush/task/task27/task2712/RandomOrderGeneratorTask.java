package com.javarush.task.task27.task2712;

/*
В отдельном классе создай таск (Runnable) RandomOrderGeneratorTask. Этот таск должен:
2.1. Хранить список всех планшетов
2.2. Используя Math.random выбирать случайный планшет.
2.3. У RandomOrderGeneratorTask должен быть только один единственный метод.
2.4. Генерировать случайный заказ каждые ORDER_CREATING_INTERVAL миллисекунд для планшета из п.2.2. (не печатай стек-трейс)
* */

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        if (tablets.size() >0){
            while (!Thread.currentThread().isInterrupted()){
                int random = (int) (Math.random() * tablets.size());
                Tablet tablet = tablets.get(random);
                tablet.createOrder();
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
