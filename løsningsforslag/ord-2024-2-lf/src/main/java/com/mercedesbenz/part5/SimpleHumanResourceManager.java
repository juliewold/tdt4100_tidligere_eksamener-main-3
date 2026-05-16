package com.mercedesbenz.part5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import no.ntnu.tdt4100.part2.Person;
import no.ntnu.tdt4100.part5.AlreadyHiredException;
import no.ntnu.tdt4100.part5.EmploymentStatus;
import no.ntnu.tdt4100.part5.ExceedsSalaryCapForAllEmployeesException;
import no.ntnu.tdt4100.part5.ExceedsSingleEmployeeSalaryCapException;
import no.ntnu.tdt4100.part5.IEmployementListener;
import no.ntnu.tdt4100.part5.IHumanResourceManager;

 /**
  * This class must implement the {@link IHumanResourceManager} interface.
  * Read the unit tests and the JavaDoc description in the interface to implement the methods correctly.
  *
  * @see IHumanResourceManager
  * @see SimpleHumanResourceManagerTests
  */
public class SimpleHumanResourceManager implements IHumanResourceManager {

    List<IEmployementListener> listeners;
    Map<Person, Integer> people;
    private int yearlySalaryCapForSingleEmployee;
    private int yearlySalaryCapForAllEmployees;
    
    /**
     * @param yearlySalaryCapForAllEmployees the maximum total yearly salary for all employees managed by <code>this</code> HR manager
     * @param yearlySalaryCapForSingleEmployee the maximum total yearly salary for a single employee managed by <code>this</code> HR manager
     */
    public SimpleHumanResourceManager(
        int yearlySalaryCapForAllEmployees, 
        int yearlySalaryCapForSingleEmployee) {
        // TODO Implement constructor to behave according to JavaDoc
        this.yearlySalaryCapForAllEmployees = yearlySalaryCapForAllEmployees;
        this.yearlySalaryCapForSingleEmployee = yearlySalaryCapForSingleEmployee;
        this.listeners = new ArrayList<>();
        this.people = new HashMap<>();
    }

    @Override
    public void addListener(IEmployementListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(IEmployementListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    @Override
    public void hire(Person p, int yearlySalary) {
        if (yearlySalary > getYearlySalaryCapForSingleEmployee()) {
            throw new ExceedsSingleEmployeeSalaryCapException();
        }
        if (getTotalYearlySalaryForAllEmployees() + yearlySalary > getYearlySalaryCapForAllEmployees()) {
            throw new ExceedsSalaryCapForAllEmployeesException();
        }

        if (people.containsKey(p)) {
            throw new AlreadyHiredException();
        }

        people.put(p, yearlySalary);

        listeners.forEach(x -> x.trigger(p, EmploymentStatus.HIRED));
    }

    @Override
    public void fire(Person p) {
        if (people.remove(p) != null) {;
            listeners.forEach(x -> x.trigger(p, EmploymentStatus.FIRED));
        }
    }

    @Override
    public int getNumberOfEmployees() {
        return people.size();
    }

    @Override
    public int getTotalYearlySalaryForAllEmployees() {
        return people.entrySet().stream().mapToInt(x -> x.getValue()).sum();
    }

    @Override
    public int getNumberOfListeners() {
        return listeners.size();
    }

    @Override
    public Optional<Integer> getSalaryFor(Person person) {
        return Optional.ofNullable(people.getOrDefault(person, null));
    }

    @Override
    public int getYearlySalaryCapForSingleEmployee() {
        return yearlySalaryCapForSingleEmployee;
    }

    @Override
    public int getYearlySalaryCapForAllEmployees() {
        return yearlySalaryCapForAllEmployees;
    }

    @Override
    public boolean isHired(Person p) {
        return people.containsKey(p);
    }
}
