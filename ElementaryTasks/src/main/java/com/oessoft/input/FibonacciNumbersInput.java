package com.oessoft.input;

import com.oessoft.exceptions.ParameterRequirementsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumbersInput {
    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    private int[] sequenceBorders = new int[2];

    public FibonacciNumbersInput() {
        String inputFromConsole;
        String[] separatedParameters;
        boolean correctInput = false;
        System.out.println("Input sequence borders separated with ';' or length of numbers in sequence: ");
        do {
            try {
                inputFromConsole = bufferedReader.readLine();
                separatedParameters = inputFromConsole.split(";");
                if (separatedParameters.length == 2) {
                    sequenceBorders = setBorders(separatedParameters[0], separatedParameters[1]);
                    correctInput = true;
                } else if (separatedParameters.length == 1) {
                    sequenceBorders = setBorders(separatedParameters[0]);
                    correctInput = true;
                } else {
                    System.out.println("Incorrect number of parameters");
                }
            } catch (IOException e) {
                System.out.println("Wrong input");
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Parameters should be positive integer numbers");
            } catch (ParameterRequirementsException e) {
                System.out.println(e.getMessage());
            }
        } while (!correctInput);
    }

    public int[] setBorders(String lowerBorder, String upperBorder) throws ParameterRequirementsException {
        int[] borders = new int[2];
        borders[0] = Integer.parseInt(lowerBorder.strip());
        borders[1] = Integer.parseInt(upperBorder.strip());
        if ((borders[0] <= 0) || (borders[1] <= 0)) {
            throw new NumberFormatException();
        }
        if (borders[0] >= borders[1]) {
            throw new ParameterRequirementsException("Maximal border should be greater than minimal border");
        }
        return borders;
    }

    public int[] setBorders(String length) throws ParameterRequirementsException {
        int[] borders = new int[2];
        int numbersLength = Integer.parseInt(length);
        if (numbersLength <= 0) {
            throw new NumberFormatException();
        }
        if (numbersLength > 9) {
            throw new ParameterRequirementsException("Length of numbers should be less than 10");
        }
        borders[0] = (int) Math.pow(10, numbersLength - 1);
        borders[1] = (int) Math.pow(10, numbersLength) -1;
        return borders;
    }

    public int[] getSequenceBorders() {
        return sequenceBorders;
    }
}
