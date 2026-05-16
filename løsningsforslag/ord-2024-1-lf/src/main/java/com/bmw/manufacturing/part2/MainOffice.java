package com.bmw.manufacturing.part2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import no.ntnu.tdt4100.ICarFactory;
import no.ntnu.tdt4100.part2.IMainOffice;

/**
 * Implement the class MainOffice.
 * 
 * The class must implement the interface {@link no.ntnu.tdt4100.part2.IMainOffice}. 
 * The class needs no constructor.
 * 
 * Read the documentation in the {@link no.ntnu.tdt4100.part2.IMainOffice} interface 
 * for detailed description on expected behaviour 
 * of the methods you need to implement.
 * 
 * @see no.ntnu.tdt4100.part2.IMainOffice
 * @see MainOfficeTests
 */

 // TODO Implement the MainOffice class here according to description in JavaDoc
public class MainOffice implements IMainOffice {

    @Override
    public double calculateInstallationHours(ICarFactory factory) {
        return Math.PI * factory.getNumberOfEmployees() * factory.getParts().size();
    }

    @Override
    public long calculateTotalEstimatedRevenue(List<ICarFactory> factories, int year) {
        long sum = 0L;
        for (ICarFactory iCarFactory : factories) {
            long a = iCarFactory.getNumberOfUnitsProduced(year);
            long b = AVERAGE_CAR_PRICE;
            sum +=  a * b;
        }

        return (long)(Math.floor( sum / 1000.0) * 1000);      
    }

    @Override
    public Optional<ICarFactory> findTopFactory(List<ICarFactory> factories) {
        return factories.stream()
        .sorted(Comparator.comparingInt(ICarFactory::getNumberOfEmployees).reversed())
        .findFirst();
    }

    @Override
    public List<ICarFactory> filterFactories(List<ICarFactory> factories, char character) {
        boolean isValid = (character >= 65 && character <= 90) || (character >= 97 && character <= 122);
        String filter = isValid ? new String(new char[]{character}).toLowerCase() : "";
        return factories.stream()
        .filter(s -> s.getIsoCountryCode().toLowerCase()
                            .startsWith(filter))
                            .toList();
    } 
}
