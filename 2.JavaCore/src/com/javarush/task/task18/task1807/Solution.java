package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        char symb_to_find = ',';
        int count = 0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());

        while (fileInputStream.available() > 0) {
            int symbol = fileInputStream.read();
            if (symbol == symb_to_find) {
                ++count;
            }
        }
        fileInputStream.close();
        bufferedReader.close();
        System.out.println(count);
    }
}
