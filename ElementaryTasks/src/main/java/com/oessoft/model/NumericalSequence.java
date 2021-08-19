package com.oessoft.model;

import java.util.List;

public class NumericalSequence {
    private int length;
    private int minimalSquare;
    private List<Integer> integerSequence;

    public NumericalSequence(int length, int minimalSquare) {
        this.length = length;
        this.minimalSquare = minimalSquare;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMinimalSquare() {
        return minimalSquare;
    }

    public void setMinimalSquare(int minimalSquare) {
        this.minimalSquare = minimalSquare;
    }

    public List<Integer> getIntegerSequence() {
        return integerSequence;
    }

    public void setIntegerSequence(List<Integer> integerSequence) {
        this.integerSequence = integerSequence;
    }
}
