package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        Scanner console = new Scanner(System.in);
        String data = "";
        if (console.hasNextLine())
            data = console.nextLine();
        if (data.equals(Planet.SUN)) {
            thePlanet = Sun.getInstance();
        } else if (data.equals(Planet.MOON)) {
            thePlanet = Moon.getInstance();
        } else if (data.equals(Planet.EARTH)) {
            thePlanet = Earth.getInstance();
        } else
            thePlanet = null;

    }
}
