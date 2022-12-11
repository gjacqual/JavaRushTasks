package com.javarush.task.task13.task1319;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        String fileName = scanner.nextLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            bufferedWriter.write(str + "\n");
            if (str.equals("exit"))
                break;

        }
        scanner.close();
        bufferedWriter.close();
    }
}
