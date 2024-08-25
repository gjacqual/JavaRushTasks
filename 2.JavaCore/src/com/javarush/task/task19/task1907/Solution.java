package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int count = 0;
        StringBuilder line = new StringBuilder();
        try(FileReader r = new FileReader(input)){
            char current;
           while (r.ready()) {
               current = (char) r.read();
               line.append(current);
           }


        } catch (IOException e) {
            throw new RuntimeException();
        }
        String clearString = line.toString().replaceAll("[\\p{P}\\s]", " ");
        String[] splited = clearString.split(" ");
        for (String s : splited) {
            if (s.equals("world")) {
                count++;
            }
        }
        System.out.println(count);

        bufferedReader.close();
    }
}
