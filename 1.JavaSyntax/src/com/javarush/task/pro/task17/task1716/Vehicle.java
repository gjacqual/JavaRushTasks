package com.javarush.task.pro.task17.task1716;

/* 
Дорожное движение
*/

public interface Vehicle {

    void move();

    default void start() {
        System.out.println("Начинаю движение.");
    }
    default void stop() {
        System.out.println("Останавливаюсь.");
    }
}