package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String filename;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filename = console.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            while (reader.ready()) {
                String line = reader.readLine();
                System.out.println(new StringBuilder(line).reverse());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
