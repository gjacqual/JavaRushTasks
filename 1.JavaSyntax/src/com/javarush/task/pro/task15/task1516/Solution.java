package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        while (Files.isRegularFile(Path.of(str)) || Files.isDirectory(Path.of(str))) {
            if (Files.isRegularFile(Path.of(str))){
                System.out.printf("%s%s\n", str, THIS_IS_FILE);
            } else if (Files.isDirectory(Path.of(str))) {
                System.out.printf("%s%s\n", str, THIS_IS_DIR);
            }
            str = console.nextLine();
        }
    }
}

