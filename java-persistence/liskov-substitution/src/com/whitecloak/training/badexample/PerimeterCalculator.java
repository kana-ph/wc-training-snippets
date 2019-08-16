package com.whitecloak.training.badexample;

import com.whitecloak.training.model.Circle;
import com.whitecloak.training.model.Rectangle;

public class PerimeterCalculator {

    public void calculate(Rectangle rectangle) {
        System.out.println("The perimeter of the rectangle is: " + rectangle.getPerimeter());
    }

    public void calculate(Circle circle) {
        System.out.println("The perimeter of the circle is: " + circle.getPerimeter());
    }
}
