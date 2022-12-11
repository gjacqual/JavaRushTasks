package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(42);
        Integer number = 123;
        print(number);
    }

    static void print(int num) {
        System.out.println(num);
    }

    static void print(Integer num) {
        System.out.println(num);
    }
}
