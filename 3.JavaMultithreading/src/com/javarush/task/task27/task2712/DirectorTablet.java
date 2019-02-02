package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


    //    какую сумму заработали на рекламе, сгруппировать по дням;
    public void printAdvertisementProfit() {
        Map<Date, Double> advProfit = StatisticManager.getInstance().calculateProfit();

        double sum = 0.00;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Map.Entry<Date, Double> d : advProfit.entrySet()) {
            System.out.println(simpleDateFormat.format(d.getKey()) + " - " + String.format(Locale.ENGLISH, "%(.2f", d.getValue()));
            sum += d.getValue();
        }
        ConsoleHelper.writeMessage("Total - " + String.format(Locale.ENGLISH, "%(.2f", sum));

    }

    //    загрузка (рабочее время) повара, сгруппировать по дням;
    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> map = StatisticManager.getInstance().CookWorkloading();
        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            Date date = null;
            try {
                date = oldFormat.parse(entry.getKey());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ConsoleHelper.writeMessage(newFormat.format(date));
//            entry.getValue().forEach((name, cookTime) -> ConsoleHelper.writeMessage(String.format("%s - %d min", name, cookTime)));
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", innerEntry.getKey(), innerEntry.getValue() / 60));
            }
//            ConsoleHelper.writeMessage("");
        }
    }

    //    список активных роликов и оставшееся количество показов по каждому;
    public void printActiveVideoSet() {
        StatisticAdvertisementManager manager = StatisticAdvertisementManager.getInstance();
        Map<String, Integer> map = manager.ActiveVideoSet();
        map.forEach((name, hits) -> ConsoleHelper.writeMessage(String.format("%s - %d", name, hits)));
    }

    //    список неактивных роликов (с оставшемся количеством показов равным нулю).
    public void printArchivedVideoSet() {
        StatisticAdvertisementManager manager = StatisticAdvertisementManager.getInstance();
        Set<String> video = manager.ArchivedVideoSet();
        video.forEach(name -> ConsoleHelper.writeMessage(name));
    }
}

/*
4. Реализуй логику методов printActiveVideoSet и printArchivedVideoSet в классе DirectorTablet.
Используй методы/метод, созданные в предыдущем пункте.
Сортировать по имени видео-ролика в алфавитном порядке
Сначала английские, потом русские.

Пример вывода для printActiveVideoSet:
First Video - 100
Second video - 10
Third Video - 2
четвертое видео - 4

Через 50 показов пример вывода для printArchivedVideoSet:
Second video
Third Video
четвертое видео
* */