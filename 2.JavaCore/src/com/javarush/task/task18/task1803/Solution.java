package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        ArrayList<Integer> bytes = new ArrayList<>();

        for (int i = 0; i < 256; i++) {
            Integer aByte = 0;
            bytes.add(i, aByte);
        }

        try (FileInputStream inputStream = new FileInputStream(file)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                bytes.set(data, bytes.get(data) + 1);
            }
        } catch  (IOException e) {
            e.printStackTrace();
        }
        int max = 0;
        for (Integer b : bytes) {
            if (b > max) {
                max = b;
            }
        }

        for (int i = 0; i < 256; i++) {
            if (bytes.get(i) == max) {
                System.out.print(i + " ");
            }
        }
    }







}
