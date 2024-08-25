package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        double countSymbols = 0;
        double countSpaces = 0;

        try(FileReader fr = new FileReader(args[0])) {
            while (fr.ready()) {
                Character letter = (char) fr.read();
                if (letter.equals(' ')) {
                    countSpaces++;
                    countSymbols++;
                } else {
                    countSymbols++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        double result =  countSpaces / countSymbols * 100;
        System.out.printf("%.2f", result);
    }
}
