package com.oessoft.service;

import com.oessoft.input.FibonacciNumbersInput;
import com.oessoft.model.FibonacciNumbers;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumbersService {
    private FibonacciNumbers fibonacciNumbers;
    private int[] sequenceBorders;

    public FibonacciNumbersService() {
        FibonacciNumbersInput fibonacciNumbersInput = new FibonacciNumbersInput();
        sequenceBorders = fibonacciNumbersInput.getSequenceBorders();
        fibonacciNumbers = new FibonacciNumbers(sequenceBorders[0], sequenceBorders[1]);
        fibonacciNumbers.setFibonacciSequence(generateFibonacciSequence());
    }

    public List<Integer> generateFibonacciSequence() {
        List<Integer> fibonacciSequence = new ArrayList<>();
        int fibonacciNumber = 1;
        int previousFibonacciNumber = 1;
        int nextFibonacciNumber;
        do {
            if ((fibonacciNumber >= fibonacciNumbers.getMinBorder())
                    && (fibonacciNumber <= fibonacciNumbers.getMaxBorder())) {
                fibonacciSequence.add(fibonacciNumber);
            }
            nextFibonacciNumber = previousFibonacciNumber + fibonacciNumber;
            previousFibonacciNumber = fibonacciNumber;

            fibonacciNumber = nextFibonacciNumber;
        } while (fibonacciNumber <= fibonacciNumbers.getMaxBorder());
        return fibonacciSequence;
    }

    public FibonacciNumbers getFibonacciNumbers() {
        return fibonacciNumbers;
    }
}
