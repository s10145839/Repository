package com.pluralsight.calcengine;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        performCalculations();
//        performMoreCalculations();

//        Divider divider = new Divider();
//        doCalculation(divider, 100.0d, 50.0d);

//        Adder adder = new Adder();
//        doCalculation(adder, 25.0d, 92.0d);

        //executeInteractively();

        dynamicInteractively();
    }

    static void dynamicInteractively() {
        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf(),
        });

        System.out.println("Enter an operation and two numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        helper.process(userInput);
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double left = Double.parseDouble(parts[1]);
        double right = Double.parseDouble(parts[2]);
        CalculateBase calculation = createCalculation(operation, left, right);
        calculation.calculate();
        System.out.println("Operation performed: " + operation);
        System.out.println(calculation.getResult());
    }

    private static CalculateBase createCalculation(MathOperation operation, double left, double right) {
        CalculateBase calculation = null;
        switch(operation) {
            case ADD:
                calculation = new Adder(left, right);
                break;
            case SUBTRACT:
                calculation = new Subtracter(left, right);
                break;
            case MULTIPLY:
                calculation = new Multiplier(left, right);
                break;
            case DIVIDE:
                calculation = new Divider(left, right);
                break;
        }
        return calculation;
    }

    private static void performMoreCalculations() {
        CalculateBase[] calculations = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d),
        };
        System.out.println();
        System.out.println("Array Calculations");

        for (CalculateBase calculation : calculations) {
            calculation.calculate();
            System.out.println("Result = " + calculation.getResult());
        }
    }

    static void doCalculation(CalculateBase calculation, double left, double right) {
        calculation.setLeft(left);
        calculation.setRight(right);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());
    }

    static void performCalculations() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for(MathEquation equation: equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        System.out.println("Average result = " + MathEquation.getAverageResult());

        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overloaded result with doubles: " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftInt, rightInt);
        System.out.println("Overloaded result with ints: " + equationOverload.getResult());
    }
}



















