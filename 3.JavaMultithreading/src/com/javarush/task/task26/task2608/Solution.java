package com.javarush.task.task26.task2608;

/* 
Все методы, кроме метода main, класса Solution должны быть thread safe.
Сделайте так, чтобы оба метода могли выполняться одновременно двумя различными тредами.
synchronized(this) для этого не подходит, используй другой объект для лока.

1. Класс Solution должен содержать метод getSumOfVar1AndVar2().
2. Класс Solution должен содержать метод getSumOfVar3AndVar4().
3. Метод getSumOfVar1AndVar2() должен содержать synchronized блок.
4. Метод getSumOfVar3AndVar4() должен содержать synchronized блок.
5. Synchronized блоки методов getSumOfVar1AndVar2() и getSumOfVar3AndVar4() должны использовать мьютексы разных объектов.
*/
public class Solution {
    final int var1;
    int var2;
    int var3;
    int var4;

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        synchronized (this){
            return var1 + var2;
        }
    }

    public int getSumOfVar3AndVar4() {
        synchronized ((Integer) var1){
            return var3 + var4;
        }
    }

    public static void main(String[] args) {

    }
}
