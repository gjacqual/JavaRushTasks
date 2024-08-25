package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        List<String> array = new ArrayList<>();
        List<String> rounded = new ArrayList<>();


        try(BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            String line = reader.readLine();
            array.addAll(Arrays.stream(line.split(" ")).collect(Collectors.toList()));
        } catch  (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : array) {
            Double number = Double.parseDouble(line);
            rounded.add(String.valueOf((int)(Math.round(number))));
        }

        try(FileWriter fw = new FileWriter(file2)) {
            for (String line : rounded) {
                fw.append(line);
                fw.append(" ");
            }
        } catch  (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
