package com.javarush.task.task27.task2712.ad;

import java.util.*;

/**доступ к хранилищу рекламных роликов - класс AdvertisementStorage.*/

/*
3. В StatisticAdvertisementManager создай два (или один) метода (придумать самостоятельно), которые из хранилища
AdvertisementStorage достанут все необходимые данные - соответственно список активных и неактивных рекламных роликов.
Активным роликом считается тот, у которого есть минимум один доступный показ.
Неактивным роликом считается тот, у которого количество показов равно 0.
* */

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null){
            synchronized (StatisticAdvertisementManager.class){
                if (instance == null){
                    instance = new StatisticAdvertisementManager();
                }else {
                    return instance;
                }
            }
        }
        return instance;
    }

    private StatisticAdvertisementManager() {
    }

    public Map<String, Integer> ActiveVideoSet(){
        Map<String, Integer> result = new TreeMap<>();
        List<Advertisement> activeVideo = advertisementStorage.list();
        for (Advertisement video : activeVideo) {
            if (video.getHits() > 0){
                result.put(video.getName(), video.getHits());
            }
        }
        return result;
    }

    public Set<String> ArchivedVideoSet(){
        Set<String> result = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        List<Advertisement> activeVideo = advertisementStorage.list();
        for (Advertisement video : activeVideo) {
            if (video.getHits() == 0){
                result.add(video.getName());
            }
        }
        return result;
    }

}
