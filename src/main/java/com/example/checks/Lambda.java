package com.example.checks;

import org.apache.commons.lang.StringUtils;

public class Lambda {
    public static void main(String[] args) {
        String message = "33";
        String leftPad = StringUtils.leftPad(String.valueOf(message.length()), 4, "0");
    }
}
