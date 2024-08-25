package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        String ad = "\nJavaRush - курсы Java онлайн";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();


        String result = outputStream.toString();
        System.setOut(consoleStream);
        StringBuilder stringBuilder = new StringBuilder(result);

        int count = 0;
        int lineSize =  stringBuilder.length();
        for (int i = 0; i < lineSize; i++ ) {
            if (stringBuilder.charAt(i) == '\n') {
                count++;
            }
            if (count == 2) {
                stringBuilder.insert(i, ad);
                count = 0;
                lineSize = stringBuilder.length();
                i = i + ad.length();

            }
        }

        System.out.println(stringBuilder.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
