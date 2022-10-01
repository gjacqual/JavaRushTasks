package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean isStop = false;
        String s;
        int sum = 0;
        while (!isStop)
        {
            if (console.hasNextInt()) {
                sum = sum + console.nextInt();
            } else if (console.hasNextLine()) {
                s = console.nextLine();
                isStop = s.equals("ENTER");
            }
        }
        System.out.println(sum);
    }
}