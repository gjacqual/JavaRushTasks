package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        String hexNumber = "";
        if (decimalNumber <= 0) {
            return  hexNumber;
        }
        StringBuilder hexBuilder = new StringBuilder();
        while(decimalNumber != 0) {
            hexBuilder.insert(0, HEX.charAt(decimalNumber % 16));
            decimalNumber = decimalNumber / 16;
        }
        hexNumber = hexBuilder.toString();
        return hexNumber;
    }

    public static int toDecimal(String hexNumber) {
        int decimal = 0;
        if (hexNumber == null || hexNumber.equals("")) {
            return decimal;
        }
        for (int i = 0; i < hexNumber.length(); i++) {
            decimal = 16 * decimal + HEX.indexOf(hexNumber.charAt(i));
        }
        return decimal;
    }
}
