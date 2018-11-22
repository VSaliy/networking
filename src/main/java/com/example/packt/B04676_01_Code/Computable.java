package com.example.packt.B04676_01_Code;

public interface Computable {
    public int compute();
    
    public default int doubleNumber(int num) {
        return 2*num;
    }
    
    public default int negateNumber(int num) {
        return -1*num;
    }
}
