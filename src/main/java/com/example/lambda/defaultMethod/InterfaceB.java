package com.example.lambda.defaultMethod;

public interface InterfaceB {
    default void print() {
        System.out.println("InterfaceB");
    }
}
