package com.pluralsight.calcengine;

public class Divider extends CalculateBase{

    public Divider() {}

    public Divider(double left, double right) {
        super(left, right);
    }

    @Override
    public void calculate(){
        double value = getLeft() / getRight();
        setResult(value);
    }
}
