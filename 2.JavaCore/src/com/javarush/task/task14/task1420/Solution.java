package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            scanner.close();
            System.out.println(nod(num1, num2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static int nod(int x, int y) {
        while (x != 0 && y != 0) {
            if (x>y)
                x = x % y;
            else
                y = y % x;
        }
        return x + y;
    }
}
