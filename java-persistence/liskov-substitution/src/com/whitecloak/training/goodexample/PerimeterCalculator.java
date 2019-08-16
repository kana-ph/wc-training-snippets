package com.whitecloak.training.goodexample;

import com.whitecloak.training.model.Shape;

public class PerimeterCalculator {

    public void calculate(Shape shape) {
        System.out.println("The perimeter of the " + shape.getName() + " is: " + shape.getPerimeter());
    }
}
