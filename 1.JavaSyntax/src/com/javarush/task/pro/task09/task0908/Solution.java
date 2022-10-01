package com.javarush.task.pro.task09.task0908;

import java.sql.SQLOutput;
import java.util.List;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    private static final String HEX = "0123456789abcdef";
    private static final String[] BINARY = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000",
            "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
//        String hexNumber = "9s0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {

        String hexNumber = "";
        if (binaryNumber == null) {
            return hexNumber;
        }

        if (binaryNumber.length() % 4 != 0) {
            StringBuilder binaryTemp = new StringBuilder();
            for (int i = 0; i < (4 - (binaryNumber.length() % 4)); i++) {
                binaryTemp.insert(0, '0');
            }
            binaryTemp.append(binaryNumber);
            binaryNumber = binaryTemp.toString();
        }
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) != '0' && binaryNumber.charAt(i) != '1')
                return hexNumber;
        }

        StringBuilder hexBuilder = new StringBuilder();

        while (binaryNumber.length() > 0) {
            String firstPart = binaryNumber.substring(0, 4);

            for (int i = 0; i < BINARY.length; i++) {
                if (BINARY[i].equals(firstPart)) {
                    hexBuilder.append(HEX.charAt(i));
                }
            }
            binaryNumber = binaryNumber.substring(4);
        }


        hexNumber = hexBuilder.toString();
        return hexNumber;
    }

    public static String toBinary(String hexNumber) {
        String binaryNumber = "";
        if (hexNumber == null) {
            return binaryNumber;
        }

        StringBuilder binaryBuilder = new StringBuilder();

        for (int i = 0; i < hexNumber.length(); i++) {

            int index = HEX.indexOf(hexNumber.charAt(i));
            if (index < 0) {
                return binaryNumber;
            }
                binaryBuilder.append(BINARY[index]);
        }

        binaryNumber = binaryBuilder.toString();
        return binaryNumber;
    }
}
