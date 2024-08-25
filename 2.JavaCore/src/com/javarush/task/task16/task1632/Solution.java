package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class  Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread infinity = new Infinity();
        Thread interrupted = new Interrupted();
        Thread ura = new Ura();
        Thread warning = new Warning();
        Thread summ = new Summ();

        threads.add(infinity);
        threads.add(interrupted);
        threads.add(ura);
        threads.add(warning);
        threads.add(summ);
    }

    public static void main(String[] args) {
        for (Thread thread: threads) {
            thread.start();
        }
    }
}