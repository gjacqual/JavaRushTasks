package com.javarush.task.pro.task04.task0411;

/* 
Четные числа
*/

public class Solution {
    public static void main(String[] args) {
        for (int x = 1; x <= 15; x++) {
            if (x % 2 == 0) {
                System.out.println(x);
            }
        }
    }
}