package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        String output = bufferedReader.readLine();

        try(BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output)))  {
            String line = br.readLine();
            String[] splited = line.split(" ");

            for (String str : splited ) {
                if (isNumberString(str)) {
                    bw.write(str + " ");
                }
            }


        } catch (IOException e) {
            throw new RuntimeException();
        }
        bufferedReader.close();

    }
    private static Boolean isNumberString(String str) {
        for (int i = (str.charAt(0) == '-' ) ? 1 : 0; i < str.length(); i++) {
            if (!Character.isDigit((str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

}

