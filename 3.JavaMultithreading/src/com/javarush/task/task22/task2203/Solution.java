package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String part = null;
        try {
           int firstIndex =  string.indexOf("\t");
           int secondIndex = string.indexOf("\t", firstIndex + 1);
           part = string.substring(firstIndex + 1, secondIndex);
        } catch (Exception e) {
            throw new TooShortStringException();
        }

        return part;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
