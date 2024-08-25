package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter(args[1]);
             BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            ArrayList<String> words = new ArrayList<>();
            while (reader.ready()) {
                String line = reader.readLine();
                String[] splited = line.split(" ");
                for (String s : splited) {
                    if (s.length() > 6) {
                        words.add(s);
                    }
                }
            }
            int count = words.size();
            int i = 0;
            for (String w : words) {
                writer.write(w);
                if (i < count - 1) {
                    writer.write(",");
                }
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
