package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        String filename;
        String tag = args[0];
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filename = console.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder input = new StringBuilder();
            while (reader.ready()) {
                String line = reader.readLine();
               input.append(line);
            }
            ArrayList<Integer> indexes = new ArrayList();
            String openTag = "<" + tag;
            String closeTag = "</" + tag + ">";
            Pattern pattern1 = Pattern.compile(openTag);
            Pattern pattern2 = Pattern.compile(closeTag);
            Matcher matcher1 = pattern1.matcher(input);
            Matcher matcher2 = pattern2.matcher(input);
            while (matcher1.find()) {
                indexes.add(matcher1.start());
            }
            while (matcher2.find()) {
                indexes.add(matcher2.start());
            }
            Collections.sort(indexes);
            int countTaqs = 0;
            for (int pos : indexes) {
                if (input.substring(pos).startsWith(openTag)) {
                    countTaqs++;
                    for (int pos2 : indexes) {
                        if (pos2 <= pos) {
                            continue;
                        }
                        if (input.substring(pos2).startsWith(openTag)) {
                            countTaqs++;
                        } else if (input.substring(pos2).startsWith(closeTag)) {
                            countTaqs--;
                        }
                        if (countTaqs == 0) {
                            System.out.println(input.substring(pos, pos2 + closeTag.length()));
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
