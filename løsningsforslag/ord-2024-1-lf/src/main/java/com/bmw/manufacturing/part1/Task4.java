package com.bmw.manufacturing.part1;

import java.util.List;

import no.ntnu.tdt4100.Car;

public class Task4 {
    /**
     * Returns the heaviest car from the supplied list
     * Assume that the cars parameter is never null and 
     * that the cars parameter is always at least of length 1.
     * 
     * Comment out the line(s) that returns the heaviest car.
     * 
     * @param cars the list of cars
     * @return the heaviest car in the list
     */
    public Car pickHeaviestCar(List<Car> cars) {
        // TODO Uncomment the line(s) that returns as specified in JavaDoc

        // if(cars.size() > 0) return cars.stream().filter(c -> c.weight()>0).findFirst().get();
        if(cars.size() > 0) return cars.stream().sorted((o1, o2) -> o2.weight() - o1.weight()).findFirst().get();
        // if(cars.size() > 0) return cars.get(cars.stream().map(c -> c.weight()).findAny().get());
        // if(cars.size() > 0) return cars.get(cars.size() - 1);

        return null; // This line is only in place to make the code compile, do not remove it
    }
}
