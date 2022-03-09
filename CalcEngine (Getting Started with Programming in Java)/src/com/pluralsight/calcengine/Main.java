package com.pluralsight.calcengine;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[] left = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] right = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        if(args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], left[i], right[i]);
            }
            for (double i : results) {
                System.out.println(i);
            }
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        }
        else if(args.length == 3) {
            handleCommandLine(args);
        } else {
            System.out.println("Please provide an operation code and 2 numeric values");
        }
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        if(opCode == 'w') {
            handleWhen(parts);
        } else {
            double left = valueFromWord(parts[1]);
            double right = valueFromWord(parts[2]);
            double result = execute(opCode, left, right);
            displayResult(opCode, left, right, result);
        }
    }

    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]);
        Long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
        System.out.println(output);
    }

    private static void displayResult(char opCode, double left, double right, double result) {
        char symbol = symbolFromOpCode(opCode);
//        StringBuilder builder = new StringBuilder(20);
//        builder.append(left);
//        builder.append(" ");
//        builder.append(symbol);
//        builder.append(" ");
//        builder.append(right);
//        builder.append(" = ");
//        builder.append(result);
//        String output = builder.toString();
        String output = String.format("%.3f %c %.3f = %.3f", left, symbol, right, result);
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for (int i = 0; i < opCodes.length; i++) {
            if(opCode == opCodes[i]) {
                symbol = symbols[i];
                break;
            }
        }
        return symbol;
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double left = Double.parseDouble(args[1]);
        double right = Double.parseDouble(args[2]);
        double result = execute(opCode, left, right);
        System.out.println(result);
    }

    static double execute(char opCode, double left, double right) {
        double result;
        switch (opCode) {
            case 'a':
                result = left + right;
                break;
            case 's':
                result = left - right;
                break;
            case 'm':
                result = left * right;
                break;
            case 'd':
                result = right != 0 ? left / right : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }
        return result;
    }

    static char opCodeFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        double value = -1d;
        for(int i = 0; i < numberWords.length; i++ ) {
            if(word.equals(numberWords[i])) {
                value = i;
                break;
            }
        }
        if(value == -1d) {
            value = Double.parseDouble(word);
        }
        return value;
    }
}
