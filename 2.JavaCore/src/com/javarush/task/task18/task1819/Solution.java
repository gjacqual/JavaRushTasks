package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        List<String> buffer = new ArrayList<>();

        try (BufferedReader reader  = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.add(line);
            }
        }

        try (FileWriter fw = new FileWriter(file1);
             FileReader fr2 = new FileReader(file2)) {
            while (fr2.ready()) {
                fw.append((char) fr2.read());
            }

            for (String line : buffer) {
                fw.append(line);
            }

        } catch  (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
