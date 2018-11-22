package com.example.doubleCheckedLocking.expensiveMultithreadedVersion;

import com.example.doubleCheckedLocking.Helper;

// Correct but possibly expensive multithreaded version
public class Foo {
    private Helper helper;
    public synchronized Helper getHelper() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }

    // other functions and members...
}
