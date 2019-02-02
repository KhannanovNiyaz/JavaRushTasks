package com.javarush.task.task25.task2508;

/*
Восстанови логику класса TaskManipulator.
Требования:
2. Метод run должен каждые 100 миллисекунд выводить имя исполняемой нити в консоль.
3. Класс TaskManipulator должен иметь внутреннее поле типа Thread.
4. Метод start должен создавать, сохранять во внутреннее поле и запускать нить с именем, которое передано через аргумент метода.
5. Метод stop должен прерывать последнюю созданную классом TaskManipulator нить.
*/
public class TaskManipulator implements Runnable, CustomThreadManipulator {
   Thread tempThird;


    @Override
    public void run() {
        while (!tempThird.isInterrupted()) {
            try {
                System.out.println(tempThird.getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                tempThird.interrupt();
            }
        }
    }

    @Override
     public void start(String threadName) {
        tempThird = new Thread(this, threadName);
        tempThird.setDaemon(true);
//        tempThird = new Thread(this);
//        tempThird.setName(threadName);
       tempThird.start();
    }

    @Override
     public void stop() {
        tempThird.interrupt();
    }
}
