package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        String output = bufferedReader.readLine();

        try(BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output)))  {

            String line = null;
            while (br.ready()) {
                line = br.readLine().replaceAll("\\.", "!");
                bw.write(line);
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
        bufferedReader.close();
    }
}
