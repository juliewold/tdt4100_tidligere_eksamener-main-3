package com.twowheels.assembly.part1;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    /* This method takes a list of strings and a substring as input. 
     * It filters out the strings that contain the substring (case-insensitive), 
     * converts the remaining strings to uppercase, sorts them, and prints them.
     * 
     * Example: 
     * For input ["Apple", "banana", "Cherry", "apricot", "Avocado"] and substring "ap"
     * the output should be:
     * 
     * AVOCADO
     * BANANA
     * CHERRY
     */

    public void filterAndProcessStrings(List<String> strings, String substring) {

        // TODO: Comment in the correct line of code.
        
        strings.stream()
               .filter(str -> !str.toLowerCase().contains(substring.toLowerCase()))
               .map(String::toUpperCase).sorted().collect(Collectors.toList())
               // .sorted().map(String::toUpperCase).collect(Collectors.toList())
               // .map(String::toUpperCase).collect(Collectors.toList())       
               // .map(String::toLowerCase).sorted().collect(Collectors.toList())
               .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Task2 task = new Task2();
        List<String> input = Arrays.asList("Apple", "banana", "Cherry", "apricot", "Avocado");
        task.filterAndProcessStrings(input, "ap");
    }
}


