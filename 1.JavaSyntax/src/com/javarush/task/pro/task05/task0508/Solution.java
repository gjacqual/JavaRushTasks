package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        strings = new String[6];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = console.nextLine();
        }
        String[] tmp = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            tmp[i] = strings[i];
            for (int j = 0; j < i; j++) {
                if (strings[i].equals(strings[j])) {
                    tmp[i] = null;
                    tmp[j] = null;
                    break;
                }
            }
        }
        strings = tmp;

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
