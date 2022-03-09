package com.lesson5;

import java.awt.*;

abstract public class Shape {
    private Color color;
    public void darken() {

    }
    public void draw(Graphics g) {
        g.setColor(color);
        render(g);
    }
    abstract protected void render(Graphics g);
}

class Circle extends Shape {
    private Point Ceneter;
    private int radius;
    public void render(Graphics g) {

    }
}