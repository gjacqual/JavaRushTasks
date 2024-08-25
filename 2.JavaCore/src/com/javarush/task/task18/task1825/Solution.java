package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.trim().compareTo(s2.trim());
            }
        });
        String outputName = "";

        while(true) {
            String filename = bufferedReader.readLine();
            if ("end".equals(filename)) {
                break;
            }
            treeSet.add(filename);
            outputName = filename;
        }
        outputName = outputName.replaceFirst(".part[\\d]+", "");

        for (String f: treeSet) {
            try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(f));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputName, true))) {
                int i;
                while ((i = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(i);
                }
            }
        }



    }
}
