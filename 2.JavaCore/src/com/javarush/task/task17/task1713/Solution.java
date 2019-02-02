package com.javarush.task.task17.task1713;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* 
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.

Требования:
1. Класс Solution должен реализовывать интерфейс List.
2. Класс Solution должен содержать private поле original типа ArrayList.
3. Все переопределенные методы интерфейса List должны делегировать полномочия методам объекта original.
4. Все методы класса Solution, кроме метода main, должны быть синхронизированы.
*/

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {


    }


    synchronized public void trimToSize() {
        original.trimToSize();
    }

    synchronized public void ensureCapacity(int minCapacity) {
        original.ensureCapacity(minCapacity);
    }

    @Override
    synchronized public int size() {
        return original.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return original.contains(o);
    }

    @Override
    synchronized public int indexOf(Object o) {
        return original.indexOf(o);
    }

    @Override
    synchronized public int lastIndexOf(Object o) {
        return original.lastIndexOf(o);
    }

    @Override
    synchronized public Object clone() {
        return original.clone();
    }

    @Override
    synchronized public Object[] toArray() {
        return original.toArray();
    }

    @Override
    synchronized public <T> T[] toArray(T[] a) {
        return original.toArray(a);
    }

    @Override
    synchronized public Long get(int index) {
        return original.get(index);
    }

    @Override
    synchronized public Long set(int index, Long element) {
        return original.set(index, element);
    }

    @Override
    synchronized public boolean add(Long aLong) {
        return original.add(aLong);
    }

    @Override
    synchronized public void add(int index, Long element) {
        original.add(index, element);
    }

    @Override
    synchronized public Long remove(int index) {
        return original.remove(index);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return original.remove(o);
    }

    @Override
    synchronized public void clear() {
        original.clear();
    }

    @Override
    synchronized public boolean addAll(Collection<? extends Long> c) {
        return original.addAll(c);
    }

    @Override
    synchronized public boolean addAll(int index, Collection<? extends Long> c) {
        return original.addAll(index, c);
    }

    @Override
    synchronized public boolean removeAll(Collection<?> c) {
        return original.removeAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection<?> c) {
        return original.retainAll(c);
    }

    @Override
    synchronized public ListIterator<Long> listIterator(int index) {
        return original.listIterator(index);
    }

    @Override
    synchronized public ListIterator<Long> listIterator() {
        return original.listIterator();
    }

    @Override
    synchronized public Iterator<Long> iterator() {
        return original.iterator();
    }

    @Override
    synchronized public List<Long> subList(int fromIndex, int toIndex) {
        return original.subList(fromIndex, toIndex);
    }

    @Override
    synchronized public void forEach(Consumer<? super Long> action) {
        original.forEach(action);
    }

    @Override
    synchronized public Spliterator<Long> spliterator() {
        return original.spliterator();
    }

    @Override
    synchronized public boolean removeIf(Predicate<? super Long> filter) {
        return original.removeIf(filter);
    }

    @Override
    synchronized public void replaceAll(UnaryOperator<Long> operator) {
        original.replaceAll(operator);
    }

    @Override
    synchronized public void sort(Comparator<? super Long> c) {
        original.sort(c);
    }

    @Override
    synchronized public boolean equals(Object o) {
        return original.equals(o);
    }

    @Override
    synchronized public int hashCode() {
        return original.hashCode();
    }

    @Override
    synchronized public boolean containsAll(Collection<?> c) {
        return original.containsAll(c);
    }

    @Override
    synchronized public String toString() {
        return original.toString();
    }

    @Override
    synchronized public Stream<Long> stream() {
        return original.stream();
    }

    @Override
    synchronized public Stream<Long> parallelStream() {
        return original.parallelStream();
    }
}
