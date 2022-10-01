package com.javarush.task.pro.task05.task0519;

import java.lang.reflect.Array;
import java.util.Arrays;

/* 
Есть ли кто?
*/

public class Solution {

    public static int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static int element = 5;

    public static void main(String[] args) {
        int[] array2 = Arrays.copyOf(array, array.length);
        Arrays.sort(array2);
        boolean answer = Arrays.binarySearch(array2, element) > -1;
        System.out.println(answer);
    }
}
