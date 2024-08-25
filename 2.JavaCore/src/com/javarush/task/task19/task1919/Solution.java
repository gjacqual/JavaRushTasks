package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Double> salaryMap = new TreeMap<>();


        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] splited = line.split(" ");
                if (salaryMap.containsKey(splited[0])) {
                    Double slalaryValue = salaryMap.get(splited[0]) + Double.parseDouble(splited[1]);
                    salaryMap.put(splited[0], slalaryValue);
                } else {
                    salaryMap.put(splited[0], Double.parseDouble(splited[1]));
                }
            }

            for (Map.Entry<String, Double> entry: salaryMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
