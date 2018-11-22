package com.example.modernJavaRecipes.basics._1_4_functionalInterfaces;

@FunctionalInterface
public interface MyInterface {
    int myMethod(); //Single abstract method
    // int myOtherMethod(); //If added, this would no longer be a functional interface
    default String sayHello() {
        return "Hello, World!";
    }
    static void myStaticMethod() {
        System.out.println("I'm a static method in an interface");
    }

    boolean equals(Object obj);
}
