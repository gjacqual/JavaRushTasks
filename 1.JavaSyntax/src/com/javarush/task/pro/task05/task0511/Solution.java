package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rows = console.nextInt();

        multiArray = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int colLength = console.nextInt();
            multiArray[i] = new int[colLength];
        }
    }
}
