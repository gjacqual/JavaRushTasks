package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String filename = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filename = console.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            while (reader.ready()) {
                int counter = 0;
                String line = reader.readLine();
                String[] splited = line.split(" ");

                for (String s : splited) {
                    if (words.contains(s)) {
                        counter++;
                    }
                }
                if (counter == 2) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


}
