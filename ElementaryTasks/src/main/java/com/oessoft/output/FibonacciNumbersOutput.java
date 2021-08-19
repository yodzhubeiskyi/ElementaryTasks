package com.oessoft.output;

import com.oessoft.service.FibonacciNumbersService;
import com.oessoft.service.MainMenuService;

import java.util.List;

public class FibonacciNumbersOutput {
    private List<Integer> fibonacciSequence;

    public FibonacciNumbersOutput(FibonacciNumbersService fibonacciNumbersService) {
        fibonacciSequence = fibonacciNumbersService.getFibonacciNumbers().getFibonacciSequence();
    }

    public void printFibonacciSequence() {
        if(fibonacciSequence.size() != 0) {
            StringBuilder outputBuilder = new StringBuilder();
            fibonacciSequence.forEach(fn -> outputBuilder.append(fn).append(", "));
            outputBuilder.delete(outputBuilder.length() - 2, outputBuilder.length());
            System.out.println(outputBuilder);
        } else {
            System.out.println("There are no fibonacci numbers that meet requirements");
        }
        MainMenuService.showTaskSelection();
    }
}
