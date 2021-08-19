package com.oessoft.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParameterInput {
    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    public static int getIntegerParameterFromConsole() {
        int integerParameter = 0;
        boolean correctInput = false;
        do {
            try {
                integerParameter = Integer.parseInt(bufferedReader.readLine());
                correctInput = true;
            } catch (IOException | NumberFormatException exception) {
                System.out.println("Wrong input. Enter an integer number");
            }
        } while (!correctInput);
        return integerParameter;
    }

    public static String getFormattedStringParameter(String parameterInRawFormat) {
        String formattedParameter = parameterInRawFormat.strip().replaceAll("[ ]+", " ");
        return formattedParameter;
    }

    public static String getStringParameterFromConsole() {
        String stringParameter = "";
        try {
            stringParameter = bufferedReader.readLine().strip();
        } catch (IOException e) {
            System.out.println("Wrong input");
        }
        return stringParameter;
    }
}
