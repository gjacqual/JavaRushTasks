package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if (data.equals("exit"))
                    break;
            if (data.indexOf(".") >= 0 && isNumericDouble(data))
                print(Double.parseDouble(data));
             else if (isNumericShort(data))
                print(Short.parseShort(data));
             else if (isNumericInt(data))
                 print(Integer.parseInt(data));
             else
                 print(data);

        }
    }

    public static boolean isNumericDouble(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public static boolean isNumericShort(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double sh = Short.parseShort(strNum);
            if (sh <= 0 || sh >= 128)
                return false;

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumericInt(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double sh = Integer.parseInt(strNum);
            if (sh > 0 && sh < 128)
                return false;

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
