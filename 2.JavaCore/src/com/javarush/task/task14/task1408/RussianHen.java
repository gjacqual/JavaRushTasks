package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {

    private static int count = 5;

    @Override
    int getCountOfEggsPerMonth() {
        return count;
    }

    @Override
    String getDescription() {

        String sf = String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(),  Country.RUSSIA, getCountOfEggsPerMonth());
        return sf;
    }
}
