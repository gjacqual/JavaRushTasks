package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month[] getWinterMonths() {

        Month[] array = new Month[] {DECEMBER, JANUARY, FEBRUARY};
        return array;
    }
    public static Month[] getSpringMonths() {

        Month[] array = new Month[] {MARCH,APRIL,MAY};
        return array;
    }
    public static Month[]  getSummerMonths() {

        Month[] array = new Month[] {JUNE, JULY, AUGUST};
        return array;
    }

    public static Month[]  getAutumnMonths() {
        Month[] array = new Month[] {SEPTEMBER, OCTOBER, NOVEMBER};
        return array;
    }



}
