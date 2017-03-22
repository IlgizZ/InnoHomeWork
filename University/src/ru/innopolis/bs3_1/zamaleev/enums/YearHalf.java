package ru.innopolis.bs3_1.zamaleev.enums;

/**
 * Created by Ilgiz on 30.08.2016.
 */
public enum YearHalf {
    FALL, SPRING;
    private int weekCount = 12;

    public int getWeekCount() {
        return weekCount;
    }
}
