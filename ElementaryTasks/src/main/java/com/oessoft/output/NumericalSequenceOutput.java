package com.oessoft.output;

import com.oessoft.service.MainMenuService;
import com.oessoft.service.NumericalSequenceService;

import java.util.List;

public class NumericalSequenceOutput {
    private List<Integer> numericalSequence;

    public NumericalSequenceOutput(NumericalSequenceService numericalSequenceService) {
        numericalSequence = numericalSequenceService.getNumericalSequence();
    }

    public void printNumericalSequence() {
        StringBuilder outputBuilder = new StringBuilder();
        for (int element : numericalSequence) {
            outputBuilder.append(element).append(", ");
        }
        outputBuilder.delete(outputBuilder.length() - 2, outputBuilder.length());
        System.out.println("Result sequence:");
        System.out.println(outputBuilder);
        MainMenuService.showTaskSelection();
    }
}
