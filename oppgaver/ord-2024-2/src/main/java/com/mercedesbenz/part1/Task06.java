package com.mercedesbenz.part1;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.tdt4100.part1.Circle;
import no.ntnu.tdt4100.part1.ITask06;
import no.ntnu.tdt4100.part1.Rectangle;
import no.ntnu.tdt4100.part1.Shape;

@SuppressWarnings({ "rawtypes", "unused" })
public class Task06 implements ITask06 {

    /**
     * Given the {@link Shape}, {@link Rectangle} and {@link Circle} classes.
     * 
     * Comment out the line(s) that will correctly calculate and return 
     * the area of the rectangle in the list.
     */
    @SuppressWarnings("unchecked")
    public double area(double l, double b) {
        // TODO Uncomment the line(s) that return the area of the rectangle

        double area = 0.0;

        List shapes = new ArrayList();
        shapes.add(new Circle(l));
        shapes.add(new Rectangle(l,b));

        // area = shape.get(3).calculateArea();
        // area = shapes.get(2).calculateArea();
        // area = shapes.get(1).calculateArea();
        // area = ((Shape)shapes.get(1)).calculateArea();
        // area = ((Rectangle)shapes.get(1)).calculateArea();
        // area = ((Rectangle)shapes.get(2)).calculateArea();

        return area;
    }
}