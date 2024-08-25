package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();


    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");


    }

    public static void main(String[] args) {
        String filename;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filename = console.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            while (reader.ready()) {
                ArrayList<String> newLine = new ArrayList();
                String line = reader.readLine();
                String[] splited = line.split(" ");
                for (String str : splited) {
                    if (str.contains(".")) {
                        str = str.replace(".", "");
                        str = changeStringContent(str) + ".";
                        newLine.add(str);
                        continue;
                    }

                    str = changeStringContent(str);
                    newLine.add(str);

                }


                System.out.println(String.join(" ", newLine));
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static boolean isDigitString(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static String changeStringContent(String str) {
        if (isDigitString(str)) {
            Integer number = Integer.parseInt(str);
            if (number > -1 && number < 13) {
                str = str.replace(str, map.get(number));
            }
        }
        return str;
    }
}
