package com.javarush.task.pro.task12.task1206;

/* 
Анализ строк
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Думаю, это будет новой ф5ичей." +
                "Только не говорите никому, что она возникла случайно 4.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        int count = 0;
        char[] stringArray = string.toCharArray();

        for (int i = 0; i < stringArray.length; i++) {
            if (Character.isDigit(stringArray[i]))
                count++;
        }
        return count;
    }

    public static int countLetters(String string) {
        int count = 0;
        char[] stringArray = string.toCharArray();

        for (int i = 0; i < stringArray.length; i++) {
            if (Character.isLetter(stringArray[i]))
                count++;
        }
        return count;
    }

    public static int countSpaces(String string) {
        int count = 0;
        char[] stringArray = string.toCharArray();

        for (int i = 0; i < stringArray.length; i++) {
            if (Character.isWhitespace(stringArray[i]))
                count++;
        }
        return count;
    }
}
