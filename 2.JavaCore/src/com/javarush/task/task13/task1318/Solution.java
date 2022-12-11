package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner console = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(console.nextLine());
        Scanner scanner = new Scanner(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }


        console.close();
        scanner.close();
        reader.close();

    }
}