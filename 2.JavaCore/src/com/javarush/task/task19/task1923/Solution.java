package com.javarush.task.task19.task1923;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        String filename1 = args[0];
        String filename2 = args[1];

        try (FileWriter writer = new FileWriter(filename2);
             BufferedReader reader = new BufferedReader(new FileReader(filename1))) {

            while (reader.ready()) {
                String line = reader.readLine();
                String[] splited = line.split(" ");
                for (String s : splited) {
                    if (isContainDigits(s)) {
                        writer.write(s + " ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static boolean isContainDigits(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
