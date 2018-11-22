package com.example.lambda.defaultMethod;

public interface InterfaceA11 extends InterfaceA{
    default void print() {
        System.out.println("InterfaceA11");
    }
}
