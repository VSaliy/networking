package com.example.packt.B04676_02_Code;

import java.util.function.Function;

public class ClosureExample {
    int instanceLength;
    
    public Function<String,String> getStringOperation() {
        String seperator = ":";
        return target -> {
            int localLength = target.length();
            instanceLength = target.length();
//            return target.toLowerCase() 
//                + ":" + instanceLength + ":" + localLength;            
            return target.toLowerCase() 
                + seperator + instanceLength + seperator + localLength;
        };
    }
}
