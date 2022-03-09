package com.pluralsight.calcengine;

public class Adder extends CalculateBase implements MathProcessing {

    public Adder() {}

    public Adder(double left, double right) {
        super(left, right);
    }

    @Override
    public void calculate(){
        double value = getLeft() + getRight();
        setResult(value);
    }

    @Override
    public String getKeyWord() {
        return "add";
    }

    @Override
    public double doCalculation(double left, double right) {
        setLeft(left);
        setRight(right);
        calculate();
        return getResult();
    }
}
