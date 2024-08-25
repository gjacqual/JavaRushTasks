package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String[] parsed = result.split(" ");
        int number1 = Integer.parseInt(parsed[0]);
        int number2 = Integer.parseInt(parsed[2]);
        int calcResult = 0;
        String operation = parsed[1];

        switch (operation) {
            case "+":
                calcResult = number1 + number2;
                break;
            case "-":
                calcResult = number1 - number2;
                break;
            case "*":
                calcResult = number1 * number2;
        }

        StringBuilder resultBuilder = new StringBuilder(result);

        resultBuilder.append(calcResult);
        System.out.println(resultBuilder);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

