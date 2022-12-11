package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try(FileReader reader = new FileReader(Statics.FILE_NAME);
            BufferedReader bfreader = new BufferedReader(reader);) {

            while (bfreader.ready()) {
               lines.add(bfreader.readLine());
            }

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {
        System.out.println(lines);
    }
}
