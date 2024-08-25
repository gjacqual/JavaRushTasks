package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] splited = line.split(" ");
                ArrayList<String> nameArray = new ArrayList();
                ArrayList<String>  dateArray = new ArrayList();
                for (String s : splited) {
                    if (isNumeric(s)) {
                        dateArray.add(s);
                    } else {
                        nameArray.add(s);
                    }
                }
                StringBuilder name = new StringBuilder();

                for (String n: nameArray) {
                    name.append(n + " ");
                }

                String nameString = name.substring(0, name.length() - 1);

                Calendar date = new GregorianCalendar(Integer.parseInt(dateArray.get(2)),
                        Integer.parseInt(dateArray.get(1)) - 1, Integer.parseInt(dateArray.get(0)));
                PEOPLE.add(new Person(nameString, date.getTime()));

            }
            for (Person p: PEOPLE) {
                System.out.println(p.getName() + " " + p.getBirthDate());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
