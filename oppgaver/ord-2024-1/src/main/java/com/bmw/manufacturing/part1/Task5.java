package com.bmw.manufacturing.part1;

import java.util.List;

import no.ntnu.tdt4100.Car;

public class Task5 {

    /**
     * Returns the summed value of all cars in the supplied list
     * If supplied parameter is null or empty, must return 0.
     * 
     * Comment out the line(s) that returns the summed value of all cars.
     * 
     * @param cars the list of cars
     * @return the summed value of cars in the list
     */
    public int getSumOfValueOfAllCars(List<Car> cars, boolean exec) {
        // TODO Uncomment the line(s) that returns as specified in JavaDoc

        if (exec) { // This line is only in place to make the code compile, do not remove it

            if (cars == null || cars.size() == 0) return 0;
            // if (cars != null && cars.size() == 0) return 0;
            // return cars.stream().map(Car::value).reduce(0, (a, b) -> a);
            return cars.stream().mapToInt(Car::value).sum();
            // return cars.stream().filter(o -> o.value() >1).collect(Collectors.summingInt(o -> o.value()));
            // return (int)cars.stream().flatMapToInt(o -> IntStream.of(o.value())).count();
            // return (int)cars.stream().mapToInt(o -> o.weight()).sum();
        }

        return 0; // This line is only in place to make the code compile, do not remove it
    }
}