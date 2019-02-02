package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    //  время выполнения заказа
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> listOfAdvertisement = storage.list();
        if (listOfAdvertisement.isEmpty()) throw new NoVideoAvailableException();

        ArrayList<Advertisement> playList = new ArrayList<>();
        ArrayList<Advertisement> tempPlaylist = new ArrayList<>();
        int maxAmount = 0;
        int maxDuration = 0;
        int minCounter = 0;
        for (int nabor = 0; nabor < Math.pow(2, listOfAdvertisement.size()); nabor++) {
            int tempAmount = 0;
            int tempDuration = 0;
            int tempCounter = 0;
            tempPlaylist.clear();
            for (int i = 0; i < listOfAdvertisement.size(); i++) {
                int mask = 1 << i;
                if ((nabor & mask) > 0) {
                    if (listOfAdvertisement.get(i).getHits() >0)
                        tempPlaylist.add(listOfAdvertisement.get(i));
                }
            }

            for (Advertisement a : tempPlaylist) {
                tempAmount += a.getAmountPerOneDisplaying();
                tempDuration += a.getDuration();
            }
            tempCounter = tempPlaylist.size();

            if (tempDuration <= timeSeconds) {
                minCounter = playList.size();
                if (tempAmount > maxAmount) {
                    playList.clear();
                    playList.addAll(tempPlaylist);
                    maxAmount = tempAmount;
                    maxDuration = tempDuration;
                    minCounter = tempCounter;
                } else if (tempAmount == maxAmount) {
                    if (tempDuration > maxDuration) {
                        playList.clear();
                        playList.addAll(tempPlaylist);
                        maxAmount = tempAmount;
                        maxDuration = tempDuration;
                        minCounter = tempCounter;
                    } else if (tempDuration == maxDuration) {
                        if (tempCounter < minCounter) {
                            playList.clear();
                            playList.addAll(tempPlaylist);
                            maxAmount = tempAmount;
                            maxDuration = tempDuration;
                            minCounter = tempCounter;
                        }
                    }
                }
            }
        }
        Collections.sort(playList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying() == 0) {
                    return (int) (((double) o1.getAmountPerOneDisplaying() / (double) o1.getDuration()) * 1000) - (int) (((double) o2.getAmountPerOneDisplaying() / (double) o2.getDuration()) * 1000);
                }
                return Math.toIntExact(o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        });
        if (storage.list().isEmpty()) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(maxDuration));
            throw new NoVideoAvailableException();
        } else {
            Collections.reverse(playList);
            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(playList, maxAmount, maxDuration));
            for (Advertisement a : playList) {
                a.revalidate();
                ConsoleHelper.writeMessage(String.format("%s  is displaying... %d, %d", a.getName(), a.getAmountPerOneDisplaying(), a.getAmountPerOneDisplaying() * 1000 / a.getDuration()));
            }
        }
    }
}