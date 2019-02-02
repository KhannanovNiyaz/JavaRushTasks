package com.javarush.task.task26.task2609;

/* 
Распределение элементов по корзинам с собственным локом
В синхронизированных блоках используй нужный лок.

4. Все методы класса Solution не должны быть synchronized.
5. В методе get() класса Solution в synchronized блоке используй lock из массива locks в зависимости
от хэша объекта и количества лок объектов.
6. В методе clear() класса Solution в synchronized блоке используй lock из массива locks в зависимости
от индекса элемента и количества лок объектов.
*/
public class Solution {
    private static final int NUMBER_LOCKS = 12;
    private final Node[] buckets;
    private final Object[] locks;

    static class Node {
        public Node next;
        public Object key;
        public Object value;
    }

    public Solution(int numberBuckets) {
        buckets = new Node[numberBuckets];
        locks = new Object[NUMBER_LOCKS];
        for (int i = 0; i < NUMBER_LOCKS; i++) {
            locks[i] = new Object();
        }
    }

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash%locks.length]) {
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) return m.value;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i % locks.length]) {
                buckets[i] = null;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(5);
        System.out.println(solution.locks.length);
    }
}
//
//    Нам необходимо, чтобы несколько нитей работали с buckets. Можно было бы при входе в него одной из нитей блокировать
// весь buckets для других нитей, но это не рационально.
//        Надо разбить buckets на 12 частей (по кол-ву объектов в locks) и блокировать только одну из этих частей, а
// другие в это время не будут блокированы. Это ускорит работу в 12 раз (в оптимальном случае).
//
//        Исходя из вышесказанного, нужно всего лишь разработать две простеньких формулы:
//        1. имея hashCode объекта buckets и кол-во объектов в locks определить нужный индекс locks.
//        2 .имея индекс объекта buckets  и кол-во объектов в locks определить нужный индекс locks.