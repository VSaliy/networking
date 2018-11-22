package com.example.packt.B04676_02_Code;

import java.util.function.Consumer;

public class ConsumerImpl<T> implements Consumer<T> {
        @Override
        public void accept(T t) {
            System.out.println(t);
        } 
}
