package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            System.out.println(exceptions.get(3));
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String string = null;
            System.out.println(string.length());
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String string = "Ddd";
            System.out.println(Integer.parseInt(string));
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String string = "Ddd";
            System.out.println(string.charAt(5));
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int nums[] = new int[-1];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int nums[] = new int[1];
            System.out.println(nums[2]);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalThreadStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NoSuchElementException();
        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}
