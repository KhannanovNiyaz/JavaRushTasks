package com.javarush.task.task27.task2712.statistic.event;

//по нему мы определяем, является ли переданный объект событием или нет.

import java.util.Date;

public interface EventDataRow {
    EventType getType();
    Date getDate();     //реализация которого вернет дату создания записи
    int getTime();      //реализация которого вернет время - продолжительность
}
