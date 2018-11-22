package com.example.modernJavaRecipes.basics._1_5_defaultMethodsInInterfaces;

import java.util.Arrays;
import java.util.List;

public class DefaultMethodsInInterfaces {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3,1,4,1,5,9);
        boolean removed = nums.removeIf(n -> n <= 0);   //Use the default method removeIf from Collection
        System.out.println("Elemnts were " + (removed ? "" : "NOT") + " removed");
        nums.forEach(System.out::println);  //Use the default method forEach from Iterator
    }
}
