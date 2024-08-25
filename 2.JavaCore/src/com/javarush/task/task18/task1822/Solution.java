package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while(reader.ready()) {
                String line = reader.readLine();
                String[] splitedLine = line.split(" ");
                if (splitedLine[0].equals(args[0])) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}