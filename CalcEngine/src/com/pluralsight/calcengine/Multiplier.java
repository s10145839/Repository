package com.pluralsight.calcengine;

public class Multiplier extends CalculateBase{

    public Multiplier() {}

    public Multiplier(double left, double right) {
        super(left, right);
    }

    @Override
    public void calculate(){
        double value = getLeft() * getRight();
        setResult(value);
    }
}
