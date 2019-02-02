package com.javarush.task.task14.task1418;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
2. Создай в классе Solution статические методы initList(List<Number> list), printListValues(List<Number> list),
 processCastedObjects(List<Number> list).
3. Найди блок кода которая заполняет значениями список и перемести его в метод initList.
4. Найди блок кода который в цикле for выводит на экран содержимое списка и перемести его в метод printListValues.
5. Найди блок кода в котором для каждого объекта списка проверяется тип и выводятся сообщения на экран и перемести
его в метод processCastedObjects.
6. Исправь 2 ошибки в методе printListValues так, чтобы на экран корректно выводилось содержимое переданного в
 качестве параметра списка.
7. Исправь 2 ошибки в методе processCastedObjects связанные с приведением типов
- для объекта типа Float нужно вывести "Is float value defined? " + !([Float_object].isNaN()).
- для объекта типа Double нужно вывести "Is double value infinite? " + [Double_object].isInfinite().

1. В классе Solution должны быть реализованы статические методы initList(List list), printListValues(List list),
 processCastedObjects(List list).
2. Метод initList должен заполнять полученный список произвольными значениями.
3. Метод printListValues должен выводить содержимое полученного списка на экран.
4. Метод processCastedObjects должен анализировать элементы списка и для объектов типа Float или Double выводить
на экран текст согласно условию задачи.

ля объектов типа Float необходимо выводить на экран строку формата "Is float value defined? " + !([Float_object].isNaN())
Например, для любого числа типа Float не равного Float.NaN: "Is float value defined? true"
*/

public class Solution {
    public static void main(String[] args) {
        List<Number> list = new LinkedList<Number>();
           }

    static List<Number> initList(List list) {
        list.add(new Double(1000f));
        list.add(new Double("123e-445632"));
        list.add(new Float(-90 / -3));
        list.remove(new Double("123e-445632"));
        return list;
    }

    static List<Number> printListValues(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }

    static List<Number> processCastedObjects(List list) {
        for (Object object : list) {
            //Исправь 2 ошибки
            if (object instanceof Double) {
                Double a = (Double) object;
                System.out.println("Is double value infinite? " + a.isInfinite());
            } else if (object instanceof Float) {
                Float a = (Float) object;
                System.out.println("Is float value defined? " + !(a.isNaN()));
            }
        }
        return list;
    }
}
