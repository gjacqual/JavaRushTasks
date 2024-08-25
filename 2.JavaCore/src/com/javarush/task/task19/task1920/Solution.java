package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Double> salaryMap = new TreeMap<>();
        TreeSet setValue = new TreeSet<>();

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
            Double maxSalary = -1.0;
            for (String key : salaryMap.keySet()) {
                if (salaryMap.get(key) > maxSalary) {
                    maxSalary = salaryMap.get(key);
                }
            }
            for (String key : salaryMap.keySet()) {
                if (Objects.equals(salaryMap.get(key), maxSalary)) {
                    setValue.add(key);
                }
            }



            for (Object el : setValue) {
                System.out.println(el);
            }




        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
