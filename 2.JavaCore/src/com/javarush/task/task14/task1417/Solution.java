package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
3. В отдельном файле создай классы Hrivna, Ruble и USD, которые будут являться потомками класса Money.
4. В классах Hrivna, Ruble и USD реализуй метод getCurrencyName который будет возвращать название соответствующей
валюты(строку) в виде аббревиатуры(USD, HRN, RUB).
5. В классах Hrivna, Ruble и USD реализуй публичный(public) конструктор, который принимает один параметр и вызывает
конструктор базового класса(super) с этим параметром.
6. Заполни список allMoney объектами всех возможных, в рамках условия задачи и функциональности программы, валют.

4. Классы Hrivna, Ruble и USD должны быть потомками класса Money и существовать в отдельных файлах.
5. В классах Hrivna, Ruble и USD должен быть реализован метод getCurrencyName.
6. Метод getCurrencyName должен возвращать название соответствующей валюты(строку) в виде аббревиатуры(USD, HRN, RUB).
7. В классах Hrivna, Ruble и USD должен быть реализован публичный конструктор с одним параметром типа double, который
устанавливает значение поля amount класса
 Money путем вызова конструктора класса родителя c тем же параметром.
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            allMoney.add(new Ruble(266));
            allMoney.add(new USD(789));
            allMoney.add(new Hrivna(746));
            //напишите тут ваш код
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
