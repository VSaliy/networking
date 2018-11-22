package com.example.packt.B04676_07_Code.strategy.traditional;

import java.util.List;

public class STFStrategy implements SchedulingStrategy {

    @Override
    public Task nextTask(List<Task> tasks) {
        Task shortest = tasks.get(0);
        for(Task task : tasks) {
            if(shortest.getDuration() > task.getDuration()) {
                shortest = task;
            }
        }
        return shortest;
    }    
}
