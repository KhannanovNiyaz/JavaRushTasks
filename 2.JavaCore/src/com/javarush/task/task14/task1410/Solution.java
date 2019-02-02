package com.javarush.task.task14.task1410;

/* 
4. Написать реализацию методов getDeliciousDrink, getWine, getBubblyWine.
5. Все классы должны находиться в отдельных файлах.
Требования:
7. В классе Solution должен быть реализован метод getDeliciousDrink(), который возвращает объект типа Wine.
8. В классе Solution должен быть реализован метод getWine(), который возвращает объект типа Wine.
9. В классе Solution должен быть реализован метод getBubblyWine(), который возвращает объект типа BubblyWine.
*/

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {
        return new Wine();

    }

    public static Wine getWine() {
        return new Wine();
    }

    public static Wine getBubblyWine() {
        return new BubblyWine();
    }
}
