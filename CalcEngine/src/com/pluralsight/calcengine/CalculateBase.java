package com.pluralsight.calcengine;

public abstract class CalculateBase {
    private double left;
    private double right;
    private double result;

    public CalculateBase() {}

    public CalculateBase(double left, double right) {
        this.left = left;
        this.right = right;
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

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public abstract void calculate();
}
