package com.example.lambda;

public interface Condition<T> {
    boolean test(T t);
}
