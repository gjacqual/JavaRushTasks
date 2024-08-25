package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        int filesize = fileInputStream.available();
        int part1;
        int part2;
        part1 = part2 = filesize / 2;
        if (filesize % 2 != 0) {
            part2++;
        }
        FileOutputStream out1 = new FileOutputStream(fileName2);
        FileOutputStream out2 = new FileOutputStream(fileName3);
        while (fileInputStream.available() > part1) {
            out1.write(fileInputStream.read());
        }
        while (fileInputStream.available() > 0) {
            out2.write(fileInputStream.read());
        }
        fileInputStream.close();
        out1.close();
        out2.close();
    }
}
