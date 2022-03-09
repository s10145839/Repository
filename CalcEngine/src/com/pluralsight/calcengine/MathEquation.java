package com.pluralsight.calcengine;

public class MathEquation {
    private double left;
    private double right;
    private char opCode;
    private double result;

    private static int numberOfCalculations;
    private static int sumOfResults;

    public  MathEquation(){}

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double left, double right) {
        this(opCode);
        this.left = left;
        this.right = right;
    }

    public void execute() {
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
        numberOfCalculations++;
        sumOfResults += result;
    }

    public void execute(int left, int right) {
        this.left = left;
        this.right = right;
        execute();
        result = (int)result;
    }

    public void execute(double left, double right) {
        this.left = left;
        this.right = right;
        execute();
    }

    public static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double right) {
        this.right = right;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
