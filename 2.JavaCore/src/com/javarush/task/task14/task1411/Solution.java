package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        List<String> stringList = new ArrayList<>();
        while (reader.ready()) {
            key = reader.readLine();
            if (!key.equals("user") && !key.equals("loser") &&
                    !key.equals("coder") && !key.equals("proger"))
                break;
            stringList.add(key);
        }
        {
            //создаем объект, пункт 2
            for (String element: stringList) {
                if (element.equals("user")) {
                    person = new Person.User();
                } else if (element.equals("loser")) {
                    person = new Person.Loser();
                } else if (element.equals("coder")) {
                    person = new Person.Coder();
                } else if (element.equals("proger")) {
                    person = new Person.Proger();
                }
                doWork(person); //вызываем doWork

            }

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
