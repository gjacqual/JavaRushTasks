package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        for (Map.Entry el : runtimeStorage.entrySet()) {
            String key = el.getKey().toString().replaceAll(" ", "\\\\ ");
            writer.write(key + "=" + el.getValue() + "\n");
        }
        writer.flush();
    }

    public static void load(InputStream inputStream) throws IOException {

        Properties appProps = new Properties();
        appProps.load(inputStream);
        runtimeStorage = typeCastConvert(appProps);

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             OutputStream oputs =  new FileOutputStream("new.properties");
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);

            save(oputs);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(runtimeStorage);
    }

    public static HashMap<String, String> typeCastConvert(Properties prop) {
        Map step1 = prop;
        Map<String, String> step2 = (Map<String, String>) step1;
        return new HashMap<>(step2);
    }
}
