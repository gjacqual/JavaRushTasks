package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MinMaxUtil {
    public static int min(int a, int  b) {
        return a < b ? a : b;
    }

    public static int min(int a, int  b, int c) {
        int minimum = Integer.MAX_VALUE;
        int[] array = new int[]{a,b,c};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        return minimum;
    }

    public static int min(int a, int  b, int c, int d ) {
        int minimum = Integer.MAX_VALUE;
        int[] array = new int[]{a,b,c,d};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        return minimum;
    }

    public static int min(int a, int  b, int c, int d, int e ) {
        int minimum = Integer.MAX_VALUE;
        int[] array = new int[]{a,b,c,d,e};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        return minimum;
    }

    public static int max(int a, int  b) {
        return a > b ? a : b;
    }

    public static int max(int a, int  b, int c) {
        int max = Integer.MIN_VALUE;
        int[] array = new int[]{a,b,c};

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int max(int a, int  b, int c, int d) {
        int max = Integer.MIN_VALUE;
        int[] array = new int[]{a,b,c, d};

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    public static int max(int a, int  b, int c, int d, int e) {
        int max = Integer.MIN_VALUE;
        int[] array = new int[]{a,b,c,d,e};

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }



}
