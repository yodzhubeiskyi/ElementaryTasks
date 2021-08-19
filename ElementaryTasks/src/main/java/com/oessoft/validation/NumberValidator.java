package com.oessoft.validation;

public class NumberValidator {
    public static boolean checkIfIntegerNumberPositive(int number) {
        if (number <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkIfDoubleNumberPositive(double number) {
        if (number <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
