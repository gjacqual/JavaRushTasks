package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String fileName = br.readLine();
            if ("exit".equals(fileName)) {
                break;
            }
            Thread th1 = new ReadThread(fileName);
            th1.start();

        }

    }

    public static class ReadThread extends Thread {

        private String fileName;
        Map<Integer, Integer> bytes = new HashMap<>();
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;


        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try(FileInputStream stream = new FileInputStream(fileName)) {

                int i;
                while((i = stream.read())!= -1) {

                    if (bytes.containsKey(i)) {
                        int val =  bytes.get(i);
                        val++;
                        bytes.put(i, val);
                    } else {
                        bytes.put(i, 1);
                    }
                }

                int maxValueInMap = Collections.max(bytes.values());
                int maxKey = 0;
                for (Map.Entry<Integer, Integer> entry: bytes.entrySet()) {
                    if (entry.getValue() == maxValueInMap) {
                        maxKey = entry.getKey();
                    }
                }

                resultMap.put(fileName, maxKey);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    }
