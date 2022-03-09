package com.pluralsight.calcengine;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyWord();
    double doCalculation(double left, double right);
    default String getFormattedOutput() {
        return null;
    }
}
