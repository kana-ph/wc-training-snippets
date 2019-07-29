package com.whitecloak.training.model;

public class Circle implements Shape {

    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public int getPerimeter() {
        return (int) (2 * Math.PI * radius);
    }
}
