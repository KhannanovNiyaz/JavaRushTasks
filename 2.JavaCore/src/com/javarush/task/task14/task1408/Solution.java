package com.javarush.task.task14.task1408;

/* 
3. В классе Hen должен быть реализован метод String getDescription(), который возвращает строку "Я - курица.".
4. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны наследоваться от класса Hen и быть созданы в отдельных файлах.
5. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны реализовывать метод getCountOfEggsPerMonth, который должен возвращать количество яиц в месяц от данного типа куриц.
6. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны переопределять метод getDescription родительского класса, таким образом, чтобы возвращаемая ими строка имела вид: + < Моя страна - Sssss. Я несу N яиц в месяц.> где Sssss - название страны, а N - количество яиц в месяц.
7. Метод getHen должен быть реализован в классе HenFactory и должен возвращать тип кур для переданной в него страны.
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
        //System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (country.equals(Country.BELARUS)){
                hen = new BelarusianHen();
            } else if (country.equals(Country.MOLDOVA)){
                hen = new MoldovanHen();
            } else if (country.equals(Country.RUSSIA)){
                hen = new RussianHen();
            } else if (country.equals(Country.UKRAINE)){
                hen = new UkrainianHen();
            }
            //напишите тут ваш код
            return hen;
        }
    }


}
