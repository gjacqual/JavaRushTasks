package com.javarush.task.pro.task05.task0507;

import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        array = new int[n];
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                array[i] = console.nextInt();
            }
            int max = array[0];
            for (int i = 0; i < n; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            System.out.println(max);
        }
    }
}

