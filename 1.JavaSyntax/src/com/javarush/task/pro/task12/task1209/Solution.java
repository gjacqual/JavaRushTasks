package com.javarush.task.pro.task12.task1209;

import java.util.ArrayList;
import java.util.Objects;

/* 
Бухгалтерия
*/

public class Solution {
    public static ArrayList<String> waitingEmployees = new ArrayList<>();
    public static ArrayList<String> alreadyGotSalaryEmployees = new ArrayList<>();

    public static void initEmployees() {
        waitingEmployees.add("Гвинно");
        waitingEmployees.add("Гунигерд");
        waitingEmployees.add("Боргелейф");
        waitingEmployees.add("Нифрод");
        waitingEmployees.add("Альбиуф");
        waitingEmployees.add("Иногрим");
        waitingEmployees.add("Фриле");
    }

    public static void main(String[] args) {
        initEmployees();
    }

    public static void paySalary(String name) {
        if (name != null) {
            if (waitingEmployees.contains(name)) {
                for (int i = 0; i < waitingEmployees.size(); i++) {
                    if (Objects.equals(waitingEmployees.get(i), name)) {
                        alreadyGotSalaryEmployees.add(name);
                        waitingEmployees.set(i, null);
                    }
                }
            }
        }
    }
}
