package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        ArrayList<Integer> bytes = new ArrayList<>();

//        for (int i = 0; i < 256; i++) {
//            Integer aByte = 0;
//            bytes.add(i, aByte);
//        }

        try (FileInputStream inputStream = new FileInputStream(file)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if (!bytes.contains(data)) {
                    bytes.add(data);
                }
            }
        } catch  (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(bytes);


        for (Integer b: bytes) {
            System.out.print(b + " ");
        }
    }
}
