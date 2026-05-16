package com.mercedesbenz.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


@SuppressWarnings("unused")
public class Task05 {

    /**
     * Comment out the line(s) that return the sum of unique even numbers from the array.
     * Ie if the array contains values 2, 3, 5, 6, 5, 3, 2, 4, the sum will be 10 because only 6 and 4 are unique even numbers.
     * 
     * Hint: an int array can be declared as follows: {@code new int[]{2,3,5}}
     */
    public int sum(int[] numbers) {
        // TODO Uncomment the line(s) that return the sum of unique numbers

        List<Integer> list = IntStream.of(numbers).mapToObj(Integer::valueOf).collect(Collectors.toList());
        
        // return Arrays.stream(numbers).filter(x -> x & 1 != 0).sum();
        // return (int) Arrays.asList(numbers).stream().count();
        // return new HashSet<Integer>(IntStream.of(numbers).boxed().toList()).stream().collect(Collectors.summingInt(Integer::intValue));
        // return Arrays.stream(numbers).filter(n -> n % 2 == 0).distinct().sum();
        // return list.stream().filter(number -> Collections.frequency(list, number) == 1 && (number & 1) != 1).mapToInt(x -> (int) x).sum();

        return -1; // This line is only in place to make the code compile, remove it after you uncomment above
    }

}