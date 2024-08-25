package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        int countLetters = 0;
        Set abc = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z'));

        try(FileReader fr = new FileReader(args[0])) {
            while (fr.ready()) {
                Character letter = (char) fr.read();
                if (abc.contains(Character.toLowerCase(letter))) {
                    countLetters++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println(countLetters);

    }
}


