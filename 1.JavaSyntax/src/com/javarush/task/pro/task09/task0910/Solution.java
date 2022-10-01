package com.javarush.task.pro.task09.task0910;

/* 
Кодировка Unicode
*/

public class Solution {
    public static void main(String[] args) {
        char[] symbols = new char[9];
        init(symbols);
        System.out.println(new String(symbols));
    }

    public static void init(char[] symbols) {


        char[] symbols2 = new char[]{'\u00A9', '\u004A', '\u0061', '\u0076', '\u0061', '\u0052', '\u0075', '\u0073', '\u0068'};

        System.arraycopy(symbols2, 0, symbols, 0, symbols.length);
    }
}
