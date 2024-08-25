package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(string1));

        while(bufferedReader.ready()) {
            allLines.add(bufferedReader.readLine());
        }

        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(string2));
        while(bufferedReader2.ready()) {
            forRemoveLines.add(bufferedReader2.readLine());
        }
        Solution solution = new Solution();
        solution.joinData();

        bufferedReader2.close();
        bufferedReader.close();

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
