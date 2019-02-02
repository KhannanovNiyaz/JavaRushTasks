package com.javarush.task.task24.task2406;

import java.math.BigDecimal;

/* 
Внутри класса Solution создай 2 внутренних public класса Apt3Bedroom, BigHall.
Унаследуй их от Apartments и Hall.

Требования:
5. Класс Apt3Bedroom должен быть потомком класса Building.Apartments.
6. Класс BigHall должен быть потомком класса Building.Hall.
*/
public class Solution {

    public class Building {

        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public class Apt3Bedroom extends Building.Apartments{
        public Apt3Bedroom(Building building) {
            building.super();
        }
    }

    public class BigHall extends Building.Hall {
        public BigHall(Building building , BigDecimal square) {
            building.super(square);
        }
    }

    public static void main(String[] args) {

    }
}
