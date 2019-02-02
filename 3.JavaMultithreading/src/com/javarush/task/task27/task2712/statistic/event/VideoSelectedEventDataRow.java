package com.javarush.task.task27.task2712.statistic.event;

/*
2.3. VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration)
optimalVideoSet - список видео-роликов, отобранных для показа
amount - сумма денег в копейках
totalDuration - общая продолжительность показа отобранных рекламных роликов
* */

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow {
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return  totalDuration;
    }

    public long getAmount() {
        return amount;
    }
}
