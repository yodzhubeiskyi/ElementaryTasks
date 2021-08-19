package com.oessoft.input;

import com.oessoft.validation.ChessBoardValidator;
import com.oessoft.validation.InputValidator;

public class ChessBoardInput {
    private int[] chessBoardParameters;

    public ChessBoardInput(String[] args) {
        int chessBoardHeight;
        int chessBoardWidth;
        if (!InputValidator.checkCorrectNumberOfParameters(args, 2
                , "Incorrect number of arguments \nPlease restart application with 2 arguments")) {
            chessBoardParameters = null;
        } else {
            try {
                chessBoardHeight = Integer.parseInt(args[0]);
                chessBoardWidth = Integer.parseInt(args[1]);
                if (!ChessBoardValidator.checkCorrectParameter(chessBoardHeight)
                        || !ChessBoardValidator.checkCorrectParameter(chessBoardWidth)) {
                    throw new NumberFormatException();
                }
                chessBoardParameters = new int[2];
                chessBoardParameters[0] = chessBoardHeight;
                chessBoardParameters[1] = chessBoardWidth;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect arguments. Height and width should integer numbers from 1 to 20");
                System.out.println("Please restart application with correct arguments");
                chessBoardParameters = null;
            }
        }
    }

    public int[] getChessBoardParameters() {
        return chessBoardParameters;
    }
}
