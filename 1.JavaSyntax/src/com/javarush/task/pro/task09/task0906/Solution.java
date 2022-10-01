package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111 1111 1111 1111 1111 1111 1111 111";
//        String binaryNumber = "1";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        String binary = "";
        if (decimalNumber < 1) {
            return binary;
        }
        while (decimalNumber > 0) {
            binary = (decimalNumber % 2) + "" + binary;
            decimalNumber /= 2;
        }
        return (binary);
    }

    public static int toDecimal(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.equals("")) {
            return 0;
        }
        String[] strings = binaryNumber.split(" ");
        binaryNumber = String.join("", strings);
        char[] binaryArray = binaryNumber.toCharArray();
        int position = binaryNumber.length() - 1;
        int decimal = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            decimal = decimal +  (binaryArray[position - i] - '0') * (int)Math.pow(2, i);
        }
        return decimal;
    }
}
