package com.example.networking.util;

import org.apache.commons.codec.binary.Hex;

public class Message {
    private String purchaseRequestMessage;

    public String purchaseRequestMessage() {
    	OtpOspiLrcCalculator calculator = new OtpOspiLrcCalculator(1, 0);
        String msg = new StringBuilder()
                .append("0045")
                .append(new String(new byte[] {SerialConstants.STX_CHAR}))
                .append("A000")
                .append(new String(new byte[] {SerialConstants.FS_CHAR}))
                .append("M0010")
                .append(new String(new byte[] {SerialConstants.FS_CHAR}))
                .append("B0000300")
                .append(new String(new byte[] {SerialConstants.FS_CHAR}))
                .append("HABDEFGLMQYv")
                .append(new String(new byte[] {SerialConstants.FS_CHAR}))
                .append("IN")
                .append(new String(new byte[] {SerialConstants.FS_CHAR}))
                .append("Y8092")
                .append(new String(new byte[] {SerialConstants.ETX_CHAR}))
                .append("3A")
                .toString();
        String message = msg + new String(calculator.calculateChecksum(msg.getBytes())); message.length(); Integer.toHexString(message.length());
        Hex.encodeHexString(message.getBytes());
        return msg;
    }

}

//.append("0035")
//.append(new String(new byte[] {SerialConstants.STX_CHAR}))
//.append("A000")
//.append(new String(new byte[] {SerialConstants.FS_CHAR}))
//.append("B3000000")
//.append(new String(new byte[] {SerialConstants.FS_CHAR}))
//.append("HABDEFGLQYv")
//.append(new String(new byte[] {SerialConstants.FS_CHAR}))
//.append("Y8092")
//.append(new String(new byte[] {SerialConstants.ETX_CHAR}))
//.append("3C")
//.toString();
