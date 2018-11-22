package com.example.lambda.defaultmethods;

import com.example.lambda.TimeClient;

import java.time.LocalDateTime;

public class SimpleTimeClient implements TimeClient {
    @Override
    public void setTime(int hour, int minute, int second) {

    }

    @Override
    public void setDate(int day, int month, int year) {

    }

    @Override
    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {

    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return null;
    }
}
