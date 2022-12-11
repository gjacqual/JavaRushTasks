package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(0.2, "test");
        labels.put(0.3, "test2");
        labels.put(0.4, "test4");
        labels.put(0.5, "tes3");
        labels.put(0.6, "test34");

    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
