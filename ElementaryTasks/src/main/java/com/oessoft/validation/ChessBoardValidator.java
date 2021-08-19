package com.oessoft.validation;

public class ChessBoardValidator {
    public static boolean checkCorrectParameter(int rawParameter) {
        if ((rawParameter >= 1) && (rawParameter <= 20)) {
            return true;
        }
        return false;
    }
}
