package com.javarush.task.task23.task2305;

/* 
Inner
*/

import javax.sound.midi.Soundbank;

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] solutions = new Solution[2];
        
        Solution solution = new Solution();
        solution.innerClasses[0] = solution.new InnerClass();
        solution.innerClasses[1] = solution.new InnerClass();

        solutions[0] = solution;

        Solution solution2 = new Solution();
        solution2.innerClasses[0] = solution2.new InnerClass();
        solution2.innerClasses[1] = solution2.new InnerClass();
        solutions[1] = solution2;
        return solutions;
    }

    public static void main(String[] args) {

    }
}
