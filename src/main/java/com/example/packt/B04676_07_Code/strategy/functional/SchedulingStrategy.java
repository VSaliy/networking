package com.example.packt.B04676_07_Code.strategy.functional;

import java.util.List;

@FunctionalInterface
public interface SchedulingStrategy {
    Task nextTask(List<Task> tasks);
}
