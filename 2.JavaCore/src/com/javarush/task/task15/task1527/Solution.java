package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        List<String> params = new ArrayList<>();
        List<List<String>> paramsList = new ArrayList<>();
        String objVal = null;


        String secondPart = url.substring(url.indexOf('?') + 1);

        params = Arrays.asList(secondPart.split("&"));
        for (String param : params) {
            if (param.indexOf('=') >= 0)
                paramsList.add(Arrays.asList(param.split("=")));
            else
                paramsList.add(Arrays.asList(param));
        }
        for (List<String> item : paramsList) {
                String value = item.get(0);
                System.out.printf("%s ", value );
                if (value.equals("obj"))
                    objVal = item.get(1);

        }
        if (objVal != null) {
            System.out.println();
            try {
                alert(Double.parseDouble(objVal));
            } catch (Exception e) {
                alert(objVal);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }
    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
