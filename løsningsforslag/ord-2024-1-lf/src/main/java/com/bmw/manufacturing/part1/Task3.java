package com.bmw.manufacturing.part1;

import no.ntnu.tdt4100.Car;

public class Task3 {
    /**
     * Returns the most valuable car of the two
     * If the cars have equal price, either can be returned. 
     * 
     * Comment out the line(s) that returns the most valuable car.
     * 
     * @param carA car A
     * @param carB car B
     * @return the most valuable car
     */
    public Car pickPriciestCar(Car carA, Car carB) {
        // TODO Uncomment the line(s) that returns the most valuable car

        if (carA.value() >= carB.value()) return carA;
        // if (carB.value() < carA.value()) return carB;
        // if (carA.value() > carA.value()) return carA;
        if (carB.value() > carA.value()) return carB;

        return null; // This line is only in place to make the code compile, do not remove it
    }
}
