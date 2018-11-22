package com.example.doubleCheckedLocking.multithreaded;

import com.example.doubleCheckedLocking.Helper;

/**
* Broken multithreaded version
* "Double-Checked Locking" idiom
**/
public class DoubleCheckedLocking {
    private Helper helper;
    public Helper getHelper() {
        if (helper == null) {
            synchronized (this) {
                if (helper == null) {
                    helper = new Helper();
                }
            }
        }
        return helper;
    }

    // other functions and members...
}
