package com.oessoft.input;

import com.oessoft.model.Triangle;
import com.oessoft.validation.InputValidator;
import com.oessoft.validation.NumberValidator;
import com.oessoft.validation.TriangleValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TriangleInput {
    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    private Triangle triangle;
    private static Set<String> triangleNames = new HashSet<>();

    public TriangleInput() {
        String[] parametersFromInput;
        String triangleName;
        double sideA;
        double sideB;
        double sideC;
        boolean correctInput = false;
        System.out.println("Enter triangle parameters in format :");
        System.out.println("<name>,<side length>,<side length>, <side length>");
        do{
            try {
                do {
                    parametersFromInput = bufferedReader.readLine().split(",");
                } while (!InputValidator.checkCorrectNumberOfParameters(parametersFromInput, 4
                        , "Incorrect number of parameters"));
                triangleName = ParameterInput.getFormattedStringParameter(parametersFromInput[0]);
                if (triangleNames.contains(triangleName)) {
                    System.out.println("Triangle with given name already exist");
                    continue;
                }
                sideA = Double.parseDouble(parametersFromInput[1]);
                sideB = Double.parseDouble(parametersFromInput[2]);
                sideC = Double.parseDouble(parametersFromInput[3]);
                if (!NumberValidator.checkIfDoubleNumberPositive(sideA)
                        || !NumberValidator.checkIfDoubleNumberPositive(sideB)
                        || !NumberValidator.checkIfDoubleNumberPositive(sideC)) {
                    System.out.println("Side length should be positive");
                    continue;
                }
                if (!TriangleValidation.checkIfTrianglePossible(sideA, sideB, sideC)) {
                    System.out.println("Impossible to build triangle with given parameters");
                    continue;
                }
                correctInput = true;
                triangle = new Triangle(triangleName, sideA, sideB, sideC);
                triangle.setArea(calculateTriangleArea(triangle));
                triangleNames.add(triangleName);
            } catch (IOException e) {
                System.out.println("Wrong input");
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Side length should be a number");
            }
        } while (!correctInput);
    }

    public double calculateTriangleArea(Triangle triangle) {
        double semiPerimeter = calculateTrianglePerimeter(triangle) / 2;
        double triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getSideA())
                * (semiPerimeter - triangle.getSideB()) * (semiPerimeter - triangle.getSideC()));
        return triangleArea;
    }

    public double calculateTrianglePerimeter(Triangle triangle) {
        double perimeter = triangle.getSideA() + triangle.getSideB() + triangle.getSideC();
        return perimeter;
    }

    public Triangle getTriangle() {
        return triangle;
    }
}
