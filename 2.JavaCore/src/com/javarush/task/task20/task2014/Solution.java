package com.javarush.task.task20.task2014;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                "/Users/filinnimac/Documents/JavaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/file1"))) {

            outputStream.writeObject(this);
        } catch (Exception e) {

        }
        try(ObjectInputStream inputStream = new  ObjectInputStream(new FileInputStream(
                "/Users/filinnimac/Documents/JavaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/file1"))) {
            Object loadedObject = inputStream.readObject();
            System.out.println(loadedObject);
        } catch (Exception e) {

        }
    }

    @Override
    public String toString() {
        return this.string;
    }
}
