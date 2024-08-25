package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {

        List<Integer> buffer = new ArrayList();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));) {

            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();

            FileInputStream fileInputStream = new FileInputStream(fileName1);
            while (fileInputStream.available() > 0) {
                buffer.add(fileInputStream.read());
            }
            FileOutputStream out1 = new FileOutputStream(fileName2);
            while (!buffer.isEmpty()) {
                out1.write(buffer.get(buffer.size() - 1));
                buffer.remove(buffer.size() - 1);
            }
            fileInputStream.close();
            out1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
