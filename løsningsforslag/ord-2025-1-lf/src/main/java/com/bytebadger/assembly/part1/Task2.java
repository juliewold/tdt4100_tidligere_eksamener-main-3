package com.bytebadger.assembly.part1;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    /**
     * This method filters a list of words and prints only those that are longer than 
     * 4 characters and start with an uppercase letter.
     */

    public void lambdaFilterExample() {
        List<String> words = Arrays.asList("Apple", "banana", "Computer", "Dog", "elephant", "Fish");

        // TODO: Comment in the correct line of code.

        List<String> filtered = words.stream()
                //.filter(word -> Character.isUpperCase(word.charAt(0)) || word.length() > 5)
                //.filter(word -> Character.isUpperCase(word.charAt(0)) && word.length() > 5)
                //.filter(word -> word.length() > 4 || Character.isUpperCase(word.charAt(0)))
                .filter(word -> word.length() > 4 && Character.isUpperCase(word.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(filtered);
    }

    public static void main(String[] args) {
        Task2 task = new Task2();
        task.lambdaFilterExample();
    }
}