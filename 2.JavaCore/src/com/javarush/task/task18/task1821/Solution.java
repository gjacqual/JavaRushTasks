package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        Map<Integer, Integer> letters = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            while(br.ready()) {
                int c = br.read();
                if (letters.containsKey(c)) {
                    int value = letters.get(c);
                    value++;
                    letters.put(c, value);
                } else {
                    letters.put(c, 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Integer> sortedKeys = new ArrayList(letters.keySet());
        Collections.sort(sortedKeys);

        for (Integer k: sortedKeys) {
            System.out.printf("%c %s\n", k.intValue(), letters.get(k));
        }
    }
}
