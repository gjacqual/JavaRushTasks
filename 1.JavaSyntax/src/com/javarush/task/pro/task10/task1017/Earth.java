package com.javarush.task.pro.task10.task1017;

/* 
Создание материков
*/

public class Earth {
    public static void main(String[] args) {
        Africa africa = new Africa(30_370_000);
        Antarctica antarctica = new Antarctica(14_100_000);
        Australia australia = new Australia(7_660_000);
        Eurasia eurasia = new Eurasia(54_760_000);
        NorthAmerica northAmerica = new NorthAmerica(24_710_000);
        SouthAmerica southAmerica = new SouthAmerica(17_840_000);
    }
}
