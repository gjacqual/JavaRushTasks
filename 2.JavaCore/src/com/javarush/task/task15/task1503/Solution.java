package com.javarush.task.task15.task1503;

/* 
ООП - машинки
*/

public class Solution {
    public static void main(String[] args) {
        new Solution.LuxuriousCar().printlnDesire();
        new Solution.CheapCar().printlnDesire();
        new Solution.Ferrari().printlnDesire();
        new Solution.Lanos().printlnDesire();
    }

    public static class Ferrari extends LuxuriousCar{
        public void printlnDesire() {
            System.out.print(Constants.WANT_STRING);
            System.out.println(Constants.FERRARI_NAME);
        }
    }

    public static class Lanos extends CheapCar{
        public void printlnDesire() {
            System.out.print(Constants.WANT_STRING);
            System.out.print(Constants.LANOS_NAME);

        }
    }

    public static class Constants {
        public static String WANT_STRING = "Я хочу ездить на ";
        public static String LUXURIOUS_CAR = "роскошной машине";
        public static String CHEAP_CAR = "дешевой машине";
        public static String FERRARI_NAME = "Феррари";
        public static String LANOS_NAME = "Ланосе";
    }
    public static class LuxuriousCar {
        private void printlnDesire() {
            System.out.print(Constants.WANT_STRING);
            System.out.println(Constants.LUXURIOUS_CAR);
        }
    }

    public static class CheapCar {
        private void printlnDesire() {
            System.out.print(Constants.WANT_STRING);
            System.out.println(Constants.CHEAP_CAR);
        }
    }
}



