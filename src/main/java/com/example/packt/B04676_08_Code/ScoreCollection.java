package com.example.packt.B04676_08_Code;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    private List<Scoreable> scores = new ArrayList<>();
    
    public static void main(String args[]) {
        
    }
    public void addScore(Scoreable score) {
        scores.add(score);
    }
    
    public int mean() {
        int total;
        total = scores.stream().mapToInt(Scoreable::getScore).sum();
        return total/scores.size();
    }
    
}
