package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
//    Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

//    public Set<Cook> getCooks() {
//        return cooks;
//    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            synchronized (StatisticManager.class) {
                if (instance == null) {
                    instance = new StatisticManager();
                } else {
                    return instance;
                }
            }
        }
        return instance;
    }

    //    будет регистрировать событие в хранилище.
    public void register(EventDataRow data) {
        if (data != null) {
            statisticStorage.put(data);
        }
    }

    //    зарегистрирует полученного повара.
//    public void register(Cook cook) {
//        if (cook != null) {
//            cooks.add(cook);
//        }
//    }

    //    будет хранить данные внутри себя в виде мапы/словаря storage.
    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType et : EventType.values()) {
                storage.put(et, new ArrayList<EventDataRow>());
            }
        }

        //   добавить объект data в данные карты чтобы методом put(EventDataRow data) добавить объект data в данные карты, нужен тип
        // события - EventType. Будет правильно, если событие будет хранить в себе свой тип. Поэтому:
        private void put(EventDataRow data) {
            if (data != null) {
                storage.get(data.getType()).add(data);
            }

        }

        public List<EventDataRow> get(EventType type) {
            return storage.get(type);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }

    //    загрузка (рабочее время) повара, сгруппировать по дням;
    public Map<String, Map<String, Integer>> CookWorkloading() {
        Map<String, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        for (EventDataRow eventDataRow : statisticStorage.get(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;
            String dataKey = format.format(cookedOrderEventDataRow.getDate());
            String cookName = cookedOrderEventDataRow.getCookName();
            int cockingTime = cookedOrderEventDataRow.getTime();
            if (!result.containsKey(dataKey)) {
                Map<String, Integer> innerMap = new TreeMap<>();
                innerMap.put(cookName, cockingTime);
                result.put(dataKey, innerMap);
            } else {
                Map<String, Integer> map = result.get(dataKey);
                if (!map.containsKey(cookName)) map.put(cookName, cookedOrderEventDataRow.getTime());
                else map.put(cookName, map.get(cookName) + cookedOrderEventDataRow.getTime());
            }
        }
        return result;
    }

    //какую сумму заработали на рекламе, сгруппировать по дням;
    public Map<Date, Double> calculateProfit() {
        Map<Date, Double> calc = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        Map<EventType, List<EventDataRow>> strg = statisticStorage.getStorage();
        List<EventDataRow> dataRowList = strg.get(EventType.SELECTED_VIDEOS);
        for (EventDataRow e : dataRowList) {

            Date currentDate = e.getDate();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.setTime(currentDate);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            double currentAmount = ((VideoSelectedEventDataRow) e).getAmount() / 100.00;
            if (calc.containsKey(calendar.getTime())) {
                currentAmount += calc.get(calendar.getTime());
            }
            calc.put(calendar.getTime(), currentAmount);
        }
        return calc;
    }
}

/*
 Из класса StatisticManager удали сет поваров, его геттер и метод register(Cook cook).
* */
