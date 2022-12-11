package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        ArrayList<Integer> array = new ArrayList<>();

        while (bufferedReader.ready()) {
            String data = bufferedReader.readLine();
            array.add(Integer.parseInt(data));
        }
        Stream<Integer> stream = array.stream().filter(x -> x % 2 == 0).sorted();
        List<Integer> result = stream.collect(Collectors.toList());

        for (Integer num:
             result) {
            System.out.println(num);

        }
        bufferedReader.close();
    }
}
