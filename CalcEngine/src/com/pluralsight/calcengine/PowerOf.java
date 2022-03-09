package com.pluralsight.calcengine;

public class PowerOf implements MathProcessing {
    private String formattedOutput;
    @Override
    public String getKeyWord() {
        return "power";
    }

    @Override
    public String getFormattedOutput() {
        return formattedOutput;
    }

    @Override
    public double doCalculation(double left, double right) {
        double product =  Math.pow(left, right);
        formattedOutput = left + " to the power of " + right + " is " + product;
        return product;
    }
}
