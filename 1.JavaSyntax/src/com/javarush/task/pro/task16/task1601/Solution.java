package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(86, Calendar.NOVEMBER, 6);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {

        int dayOfWeek = date.getDay();
        String dayText = "";

        switch (dayOfWeek) {
            case 0:
                dayText = "воскресенье";
                break;
            case 1:
                dayText = "понедельник";
                break;
            case 2:
                dayText = "вторник";
                break;
            case 3:
                dayText = "среда";
                break;
            case 4:
                dayText = "четверг";
                break;
            case 5:
                dayText = "пятница";
                break;
            case 6:
                dayText = "суббота";
                break;
        }
        return dayText;

    }
}
