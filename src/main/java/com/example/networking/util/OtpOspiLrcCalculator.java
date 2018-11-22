package com.example.networking.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtpOspiLrcCalculator {
    private static final Logger LOG = LoggerFactory.getLogger(OtpOspiLrcCalculator.class);
    private int excludeAtBeginning = 0;
    private int excludeAtEnd = 0;

    public OtpOspiLrcCalculator() {
        super();
    }


    public int getExcludeAtBeginning() {
        return excludeAtBeginning;
    }


    public void setExcludeAtBeginning(int excludeAtBeginning) {
        this.excludeAtBeginning = excludeAtBeginning;
    }


    public int getExcludeAtEnd() {
        return excludeAtEnd;
    }


    public void setExcludeAtEnd(int excludeAtEnd) {
        this.excludeAtEnd = excludeAtEnd;
    }


    public OtpOspiLrcCalculator(int excludeAtBeginning, int excludeAtEnd) {
        this.excludeAtBeginning = excludeAtBeginning;
        this.excludeAtEnd = excludeAtEnd;
    }

    public byte[] calculateChecksum(byte[] message) {
        byte result = 0x00;
        List<Byte> subList = Arrays.asList(ArrayUtils.toObject(message)).subList(getExcludeAtBeginning(), message.length - getExcludeAtEnd());

        for (byte b: subList) {
            result ^= b;
        }
        LOG.debug(String.format("Calculated LRC = %d", result));
        return Integer.toHexString(result & 0xFF).length() != 2 ? new String("0" + Integer.toHexString(result & 0xFF).toUpperCase()).getBytes() : Integer.toHexString(result & 0xFF).toUpperCase().getBytes(); // The result must be unsigned
    }

    public int getChecksumSize() {
        return 2;
    }

}
