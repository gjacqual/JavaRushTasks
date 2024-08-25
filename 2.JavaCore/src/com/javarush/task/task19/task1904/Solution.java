package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream("/Users/filinnimac/Documents/JavaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1904/file"));

        PersonScannerAdapter psa = new PersonScannerAdapter(scanner);

        String output = psa.read().toString();
        System.out.println(output);
        String output2 = psa.read().toString();
        System.out.println(output2);
    }

    public static class PersonScannerAdapter implements PersonScanner {
            private final Scanner fileScanner;

            PersonScannerAdapter(Scanner fileScanner) {
                this.fileScanner = fileScanner;
            }


        @Override
        public Person read() throws IOException {
                String line = this.fileScanner.nextLine();
                String[] splitted = line.split(" ");
                SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
                StringBuilder sb = new StringBuilder();
                sb.append(splitted[3]);
                sb.append("-");
                sb.append(splitted[4]);
                sb.append("-");
                sb.append(splitted[5]);
                String date = sb.toString();
                try {
                    Date birthDate = ft.parse(date);
                    return new Person(splitted[1], splitted[2], splitted[0], birthDate);
                } catch (ParseException e) {
                    System.out.println("Нераспаршена с помощью " + ft);
                }
                return null;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
