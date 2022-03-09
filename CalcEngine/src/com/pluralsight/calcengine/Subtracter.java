package com.pluralsight.calcengine;

public class Subtracter extends CalculateBase {

    public Subtracter() {}

    public Subtracter(double left, double right) {
        super(left, right);
    }

    @Override
    public void calculate(){
        double value = getLeft() - getRight();
        setResult(value);
    }
}
