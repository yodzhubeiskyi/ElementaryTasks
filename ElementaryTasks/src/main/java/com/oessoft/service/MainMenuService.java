package com.oessoft.service;

import com.oessoft.input.ParameterInput;
import com.oessoft.output.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMenuService {
    private static List<String> listOfTasks = Stream.of("1. Chessboard", "3. Triangles sorting"
            , "7. Numerical sequence", "8. Fibonacci numbers").collect(Collectors.toList());
    private static String[] args;

    public static void showTaskSelection() {
        System.out.println();
        listOfTasks.forEach(task -> System.out.println(task));
        System.out.println();
        System.out.println("Enter number of Task to execute:");
        selectTask();
    }

    public static void selectTask() {
        boolean correctInput = false;
        do {
            String userResponse = ParameterInput.getStringParameterFromConsole();
            switch (userResponse) {
                case "1": {
                    correctInput = true;
                    ChessBoardService chessBoardService = new ChessBoardService(args);
                    ChessBoardOutput chessBoardOutput = new ChessBoardOutput(chessBoardService);
                    chessBoardOutput.printChessBoard();
                    break;
                }
                case "3": {
                    correctInput = true;
                    TriangleService triangleService = new TriangleService();
                    TriangleOutput triangleOutput = new TriangleOutput(triangleService);
                    triangleOutput.printListOfTriangles();
                    break;
                }
                case "7": {
                    correctInput = true;
                    NumericalSequenceService numericalSequenceService = new NumericalSequenceService();
                    NumericalSequenceOutput numericalSequenceOutput = new NumericalSequenceOutput(numericalSequenceService);
                    numericalSequenceOutput.printNumericalSequence();
                    break;
                }
                case "8": {
                    correctInput = true;
                    FibonacciNumbersService fibonacciNumbersService = new FibonacciNumbersService();
                    FibonacciNumbersOutput fibonacciNumbersOutput = new FibonacciNumbersOutput(fibonacciNumbersService);
                    fibonacciNumbersOutput.printFibonacciSequence();
                    break;
                }
                default: {
                    System.out.println("Wrong Input");
                    break;
                }
            }
        } while (!correctInput);
    }

    public static void setArgs(String[] arguments) {
        args = arguments;
    }
}
