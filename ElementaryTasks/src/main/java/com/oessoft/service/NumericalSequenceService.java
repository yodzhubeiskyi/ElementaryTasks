package com.oessoft.service;

import com.oessoft.input.NumericalSequenceInput;
import com.oessoft.model.NumericalSequence;

import java.util.ArrayList;
import java.util.List;

public class NumericalSequenceService {
    List<Integer> sequenceParameters;
    NumericalSequence numericalSequence;

    public NumericalSequenceService() {
        NumericalSequenceInput numericalSequenceInput = new NumericalSequenceInput();
        sequenceParameters = numericalSequenceInput.getSequenceLengthAndMinSquare();
        numericalSequence = new NumericalSequence(sequenceParameters.get(0), sequenceParameters.get(1));
        numericalSequence.setIntegerSequence(generateSequence(sequenceParameters));
    }

    public List<Integer> generateSequence(List<Integer> parameters) {
        List<Integer> sequenceOfIntegers = new ArrayList<>();
        int firstListElementValue = (int) Math.sqrt(parameters.get(1));
        if (firstListElementValue < Math.sqrt(parameters.get(1))) {
            firstListElementValue++;

        }
        for (int i = 0; i < parameters.get(0); i++) {
            sequenceOfIntegers.add(firstListElementValue + i);
        }
        return sequenceOfIntegers;
    }

    public List<Integer> getNumericalSequence() {
        return numericalSequence.getIntegerSequence();
    }
}
