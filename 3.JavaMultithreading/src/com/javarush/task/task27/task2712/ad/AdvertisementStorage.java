package com.javarush.task.task27.task2712.ad;


import java.util.ArrayList;
import java.util.List;

//хранилище рекламных роликов.
public class AdvertisementStorage {
    public static volatile AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList();            //Хранилище видео

    //конструктор инициилизирует рекломное объявление вилео треками
    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First video", 1523, 3, 3 * 60));
        add(new Advertisement(someContent, "Second video", 5, 2, 1 * 60));
        add(new Advertisement(someContent, "Third video", 99, 0, 3 * 60));
        add(new Advertisement(someContent, "Fourth video", 99, 0, 2 * 60));
        add(new Advertisement(someContent, "Fifth video", 2506, 3, 3 * 60));
        add(new Advertisement(someContent, "Первое видео", 2506, 0, 3 * 60));
        add(new Advertisement(someContent, "Второе видео", 400, 1, 3 * 60));
        add(new Advertisement(someContent, "Третье видео", 500, 1, 2 * 60));
        add(new Advertisement(someContent, "Четвертое видео", 400, 2, 3 * 60));
        add(new Advertisement(someContent, "Пятое видео", 350, 0, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Шестое видео", 1500, 10, 2 * 60)); //15 min
        add(new Advertisement(someContent, "Седьмое видео", 4600, 2, 10 * 60));   //10 min
//        add(new Advertisement(someContent, "1", 1523, 3, 3 * 60));
//        add(new Advertisement(someContent, "2", 5, 2, 1 * 60));
//        add(new Advertisement(someContent, "3", 99, 2, 3 * 60));
//        add(new Advertisement(someContent, "4", 99, 10, 2 * 60));
//        add(new Advertisement(someContent, "5", 2506, 3, 3 * 60));
//        add(new Advertisement(someContent, "6", 2506, 3, 3 * 60));
//        add(new Advertisement(someContent, "7", 400, 1, 3 * 60));
//        add(new Advertisement(someContent, "8", 500, 1, 2 * 60));
//        add(new Advertisement(someContent, "10", 400, 2, 3 * 60));
//        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
//        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
//        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            synchronized (AdvertisementStorage.class) {
                if (instance == null) {
                    instance = new AdvertisementStorage();
                }
            }
        }
        return instance;
    }

    // вернет список всех существующих доступных видео.
    public List list() {
        return videos;
    }

    //    добавит новое видео в список videos
    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}

