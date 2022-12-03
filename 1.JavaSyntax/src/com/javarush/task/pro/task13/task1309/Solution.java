package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Вася", 4.3);
        grades.put("Лена", 5.0);
        grades.put("Mike", 2.5);
        grades.put("Kate", 3.6);
        grades.put("Victor", 4.1);
    }
}
