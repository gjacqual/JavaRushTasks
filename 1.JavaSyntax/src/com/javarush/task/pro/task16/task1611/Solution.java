package com.javarush.task.pro.task16.task1611;

import java.time.LocalTime;

/* 
Нужно просто посчитать
*/

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        LocalTime localTime = LocalTime.MIDNIGHT;
        LocalTime next = amazingMethod(localTime);
        while (next.isAfter(localTime)) {
            System.out.println(next);
            next = amazingMethod(next);
            Thread.sleep(500);
        }
    }

    static LocalTime amazingMethod(LocalTime base) {
        if (base.getHour() == 18)
            return base.plusHours(5);
        if (base.getHour() == 23)
            return base.plusHours(1);
        return base.plusHours(6);
    }
}
