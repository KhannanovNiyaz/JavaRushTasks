package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
В классе Solution создай публичный статический класс AmigoThreadFactory, реализующий интерфейс ThreadFactory.
1. Реализация интерфейсного метода - создайте и верните трэд, который должен:
1.1. не быть демоном,
1.2. иметь нормальный приоритет,
1.3. имя трэда должно иметь шаблон "GN-pool-A-thread-B",
где GN - это имя группы,
A - это номер фабрики инкрементируется в пределах класса начиная с 1, используйте AtomicInteger,
B - номер треда инкрементируется в пределах конкретной фабрики начиная с 1, используйте AtomicInteger.
2. Каждая фабрика должна иметь ту группу тредов (ThreadGroup), в которой она была создана.
3. Методы main и emulateThreadFactory не участвуют в тестировании.

Пример вывода:
secondGroup-pool-2-thread-1
firstGroup-pool-1-thread-1
firstGroup-pool-1-thread-3
secondGroup-pool-2-thread-3
firstGroup-pool-1-thread-2
secondGroup-pool-2-thread-2

Требования:
1. В классе Solution нужно создать класс public static AmigoThreadFactory, который реализует интерфейс ThreadFactory.
2. Фабрика AmigoThreadFactory должна создавать трэды, которые не являются демоном.
3. Фабрика AmigoThreadFactory должна создавать трэды, которые имеют нормальный приоритет.
4. Фабрика AmigoThreadFactory должна создавать имена для трэдов по шаблону "GN-pool-A-thread-B".
5. Каждая фабрика должна производить трэды с группой (ThreadGroup), в которой она была создана.
*/
public class Solution {
    public static class AmigoThreadFactory implements ThreadFactory {
           AtomicInteger poolNumber = new AtomicInteger(1);
          AtomicInteger threadNumber = new AtomicInteger(1);
          static AtomicInteger temp = new AtomicInteger(0);

        public AmigoThreadFactory() {
                poolNumber.set(temp.incrementAndGet());
        }

        @Override
        public Thread newThread(Runnable r) {
//            Thread t = new Thread(r, String.format("%s-pool-%d-thread-%d", Thread.currentThread().getThreadGroup(), poolNumber, threadNumber));
            Thread t = new Thread(r);
            t.setName(String.format("%s-pool-" + poolNumber + "-thread-" + threadNumber.getAndIncrement(), t.getThreadGroup().getName()));

            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
