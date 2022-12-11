package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

import org.w3c.dom.ls.LSOutput;

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public class Dog implements CanMove, CanEat{
        @Override
        public void move() {
            System.out.println("Собака бежит");
        }

        @Override
        public void eat() {
            System.out.println("Собака ест");
        }
    }

    public class Duck implements CanFly, CanEat, CanMove{
        @Override
        public void eat() {
            System.out.println("Птица ест");
        }

        @Override
        public void fly() {
            System.out.println("Птица летит");
        }

        @Override
        public void move() {
            System.out.println("Движется");
        }
    }

    public class Car implements CanMove {
        @Override
        public void move() {
            System.out.println("Cat is moving");
        }
    }

    public class Airplane implements CanFly, CanMove{
        @Override
        public void fly() {
            System.out.println("its flying");
        }

        @Override
        public void move() {
            System.out.println("Move");
        }
    }
}
