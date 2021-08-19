package com.oessoft.validation;

public class InputValidator {
    public static boolean checkCorrectNumberOfParameters(String[] parameters, int expectedAmount
            , String errorMessage) {
        if (parameters.length != expectedAmount) {
            System.out.println(errorMessage);
            return false;
        }
        return true;
    }
}
