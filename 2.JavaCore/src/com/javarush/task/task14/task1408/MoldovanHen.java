package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {

    private static int count = 8;

    @Override
    int getCountOfEggsPerMonth() {
        return count;
    }

    @Override
    String getDescription() {

        String sf = String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(), Country.MOLDOVA, getCountOfEggsPerMonth());
        return sf;
    }
}
