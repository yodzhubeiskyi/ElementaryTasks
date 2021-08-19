package com.oessoft.input;

import com.oessoft.validation.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class NumericalSequenceInput {
    private List<Integer> sequenceLengthAndMinSquare = new ArrayList<>();

    public NumericalSequenceInput() {
        int arrayLength;
        int minSquareValue;
        arrayLength = getParameter("Enter the amount of numbers to output: ");
        minSquareValue = getParameter("Enter minimal square: ");
        sequenceLengthAndMinSquare.add(arrayLength);
        sequenceLengthAndMinSquare.add(minSquareValue);
    }

    public List<Integer> getSequenceLengthAndMinSquare() {
        return sequenceLengthAndMinSquare;
    }

//    public void setSequenceParameters() {
//        int arrayLength;
//        int minSquareValue;
//        arrayLength = getParameter("Enter the amount of numbers to output: ");
//        minSquareValue = getParameter("Enter minimal square: ");
//        sequenceLengthAndMinSquare.add(arrayLength);
//        sequenceLengthAndMinSquare.add(minSquareValue);
//    }

    public int getParameter(String message) {
        int parameter = 0;
        boolean successfulValidation;
        System.out.println(message);
        do {
            parameter = ParameterInput.getIntegerParameterFromConsole();
            successfulValidation = NumberValidator.checkIfIntegerNumberPositive(parameter);
            if (!successfulValidation) {
                System.out.println("Wrong input. Enter positive integer number");
            }
        } while (!successfulValidation);
        return parameter;
    }
}
