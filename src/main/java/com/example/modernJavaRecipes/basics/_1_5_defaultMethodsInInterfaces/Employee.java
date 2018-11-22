package com.example.modernJavaRecipes.basics._1_5_defaultMethodsInInterfaces;

public interface Employee {
    String getFirst();
    String getLast();
    void convertCaffeineToCodeForMoney();
    default String getName() {  //Default method with an implementation
        return String.format("%s %s",getFirst(),getLast());
    }
}
