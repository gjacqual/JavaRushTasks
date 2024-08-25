package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        List<List<String>> bd = new ArrayList<>();

        String operation = args[0];

        if (operation.equals("-u") && args.length != 5
                || operation.equals("-d") && args.length != 2) {
            System.exit(0);
        }
        String productId = args[1];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();

        try (FileReader fileReader = new FileReader(filename);
             BufferedReader br = new BufferedReader(fileReader)) {
            while(br.ready()) {
                List<String> product = new ArrayList<>();
                String  data = br.readLine();
                String tempId = data.substring(0, 8);
                String tempName = data.substring(8,38);
                String tempPrice = data.substring(38, 46);
                String tempQuantity = data.substring(46);
                product.add(tempId);
                product.add(tempName);
                product.add(tempPrice);
                product.add(tempQuantity);
                bd.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        switch (operation) {
            case ("-u"):
                String productName = args[2];
                if (productName.length() > 30) {
                    productName = productName.substring(0, 30);
                }
                String price = args[3];
                String quantity = args[4];

                Iterator<List<String>> prodIterator1 = bd.iterator();
                while(prodIterator1.hasNext()) {
                    List<String> nextProduct = prodIterator1.next();
                    if (nextProduct.get(0).trim().equals(productId)) {
                        nextProduct.set(1, spaceFormatter(productName, productName.length(), 29));
                        nextProduct.set(2, spaceFormatter(price, price.length(), 7));
                        nextProduct.set(3, spaceFormatter(quantity, quantity.length(), 3));
                    }
                }
                break;
            case ("-d"):
                Iterator<List<String>> prodIterator2 = bd.iterator();
                while(prodIterator2.hasNext()) {
                    List<String> nextProduct = prodIterator2.next();
                    if (nextProduct.get(0).trim().equals(productId)) {
                        prodIterator2.remove();
                    }
                }
                break;
            default:
                break;
        }





        try (FileWriter fileWriter = new FileWriter(filename);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for(List<String> p: bd) {
                for (String el: p) {
                    bufferedWriter.append(el);
                }
                bufferedWriter.append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String spaceFormatter(String element, int stringLength, int maxLength) {
        StringBuilder spaces = new StringBuilder();
        spaces.append(element);
        for (int i = stringLength; i <= maxLength; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

}
