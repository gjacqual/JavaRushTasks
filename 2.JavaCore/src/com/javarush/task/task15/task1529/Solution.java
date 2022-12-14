package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
       reset();
    }

    public static CanFly result;

    public static void reset() {
        String text;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            text = scanner.nextLine();
            if (text.equals( "helicopter")) {
                result = new Helicopter();
            } else if (text.equals( "plane")) {
                result = new Plane(12);
            }
        }
        scanner.close();
    }
}
