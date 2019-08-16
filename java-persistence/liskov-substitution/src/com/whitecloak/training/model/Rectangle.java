package com.whitecloak.training.model;

public class Rectangle implements Shape {

    private final int width;
    private final int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public String getName() {
        return "rectangle";
    }

    @Override
    public int getPerimeter() {
        return (2 * width) + (2 * length);
    }
}
