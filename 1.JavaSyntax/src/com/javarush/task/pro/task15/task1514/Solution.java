package com.javarush.task.pro.task15.task1514;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Все относительно
*/

public class Solution {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            Path result = Path.of(str1).relativize(Path.of(str2));
            if (!result.toString().isEmpty()) {
                System.out.println(result);
            }
        } catch (Exception e) {

        }
    }
}

