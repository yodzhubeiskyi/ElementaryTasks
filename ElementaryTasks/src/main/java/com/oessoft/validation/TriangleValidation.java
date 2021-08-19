package com.oessoft.validation;

public class TriangleValidation {
    public static boolean checkIfTrianglePossible(double sideA, double sideB, double sideC) {
        if (((sideA + sideB) <= sideC) || ((sideA + sideC) <= sideB) || ((sideC + sideB) <= sideA)) {
            return false;
        }
        return true;
    }
}
