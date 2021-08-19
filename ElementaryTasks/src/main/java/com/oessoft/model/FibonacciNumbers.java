package com.oessoft.model;

import java.util.List;

public class FibonacciNumbers {
    private int minBorder;
    private int maxBorder;
    private List<Integer> fibonacciSequence;

    public FibonacciNumbers(int minBorder, int maxBorder) {
        this.minBorder = minBorder;
        this.maxBorder = maxBorder;
    }

    public int getMinBorder() {
        return minBorder;
    }

    public void setMinBorder(int minBorder) {
        this.minBorder = minBorder;
    }

    public int getMaxBorder() {
        return maxBorder;
    }

    public void setMaxBorder(int maxBorder) {
        this.maxBorder = maxBorder;
    }

    public List<Integer> getFibonacciSequence() {
        return fibonacciSequence;
    }

    public void setFibonacciSequence(List<Integer> fibonacciSequence) {
        this.fibonacciSequence = fibonacciSequence;
    }
}
