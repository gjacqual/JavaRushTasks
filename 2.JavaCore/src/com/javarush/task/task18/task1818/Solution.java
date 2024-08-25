package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        String file3 = br.readLine();
        try (FileWriter fw = new FileWriter(file1, true);
             FileReader fr1 = new FileReader(file2);
             FileReader fr2 = new FileReader(file3)) {
            while (fr1.ready()) {
                fw.append((char) fr1.read());
            }
            while(fr2.ready()){
                fw.append((char) fr2.read());
            }
        } catch  (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
