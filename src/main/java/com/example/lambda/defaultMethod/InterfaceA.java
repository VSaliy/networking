package com.example.lambda.defaultMethod;

public interface InterfaceA {
    default void print() {
        System.out.println("InterfaceA");
    }
}
