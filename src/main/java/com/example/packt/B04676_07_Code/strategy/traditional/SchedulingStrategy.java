package com.example.packt.B04676_07_Code.strategy.traditional;

import java.util.List;

public interface SchedulingStrategy {
    public Task nextTask(List<Task> tasks);
}
