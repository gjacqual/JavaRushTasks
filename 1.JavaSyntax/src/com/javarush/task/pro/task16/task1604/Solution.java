package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1986, 10, 6);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {

        int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
        String dayText = "";

        switch (dayOfWeek) {
            case 1:
                dayText = "воскресенье";
                break;
            case 2:
                dayText = "понедельник";
                break;
            case 3:
                dayText = "вторник";
                break;
            case 4:
                dayText = "среда";
                break;
            case 5:
                dayText = "четверг";
                break;
            case 6:
                dayText = "пятница";
                break;
            case 7:
                dayText = "суббота";
                break;
        }
        return dayText;
    }
}
