package com.example.doubleCheckedLocking.singleThreaded;

import com.example.doubleCheckedLocking.Helper;

// Single-threaded version
public class Foo {
    private Helper helper;
    public Helper getHelper() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }

    // other functions and members...
}
