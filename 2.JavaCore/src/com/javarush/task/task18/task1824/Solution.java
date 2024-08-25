package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (bufferedReader.ready()) {
                String filename = bufferedReader.readLine();
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

                } catch (FileNotFoundException e) {
                    System.out.println(filename);
                    break;
                }
            }
    }
}
