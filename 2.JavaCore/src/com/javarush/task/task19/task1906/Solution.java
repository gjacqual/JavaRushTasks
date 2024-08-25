package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        String output = bufferedReader.readLine();

        try(FileReader reader = new FileReader(input);
            FileWriter writer = new FileWriter(output)) {

            int i = 1;
            while (reader.ready()) {
                int data = reader.read();
                if ((i % 2) == 0) {
                    writer.write(data);
                }
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        bufferedReader.close();
    }
}
