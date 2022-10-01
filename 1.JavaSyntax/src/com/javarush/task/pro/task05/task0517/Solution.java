package com.javarush.task.pro.task05.task0517;

import java.util.Arrays;

/* 
Делим массив
*/

public class Solution {

    public static int[][] result = new int[2][];
    public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
        int odd = array.length % 2;
        int[] sub1 = Arrays.copyOfRange(array, 0, array.length / 2 + odd);
        int[] sub2 = Arrays.copyOfRange(array, array.length / 2 + odd, array.length);
        result[0] = sub1;
        result[1] = sub2;
        System.out.println(Arrays.deepToString(result));
    }
}
