package com.javarush.task.task20.task2015;

import java.io.*;

/*
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.

Hint/Подсказка:
Конструктор не вызывается при десериализации, только инициализируются все поля.

Требования:
3. Поле runner в классе Solution должно быть объявлено с модификатором transient.
4. В методе readObject должен быть создан новый объект типа Thread с текущим объектом в качестве параметра.
5. В методе readObject должен быть вызван метод start у нового объекта типа Thread.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;
    private boolean stop;
    private int counter = 0;

    public Solution() {
    }

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        System.out.println("..... starting new "+Thread.currentThread().getName()+ " ......");
        while (!stop) {
            System.out.println(++counter);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("..... "+Thread.currentThread().getName()+ " stoped ......");
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        System.out.println("saving counter "+this.counter + ", speed " + this.speed);
//        FileOutputStream fileOutputStream = new FileOutputStream("QWE");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(this);
//        objectOutputStream.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("loading counter "+this.counter + ", with speed " +this.speed +", continue");
        new Thread(this).start();
//        FileInputStream fileInputStream = new FileInputStream("QWE");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Solution solution = (Solution) objectInputStream.readObject();
//        Thread thread = new Thread(solution);
//        thread.start();
//        objectInputStream.close();
    }

    public static void main(String[] args) {
        try {
            File file = File.createTempFile("my_temp_file_task2015",null);
            file.deleteOnExit();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            System.out.println("counting for 2s");
            Solution sol1 = new Solution(200);
            Thread.sleep(2000);
            oos.writeObject(sol1);
            oos.close();
            System.out.println("counting for 2s");
            Thread.sleep(2000);
            sol1.stop= true;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Solution sol2 = (Solution)ois.readObject();
            ois.close();
            System.out.println("counting for 2s");
            Thread.sleep(2000);
            sol2.stop= true;
        } catch (IOException |InterruptedException |ClassNotFoundException e) {
            e.getMessage();
        }
    }
}
