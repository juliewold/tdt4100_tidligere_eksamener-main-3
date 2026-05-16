package no.ntnu.tdt4100.part5;

import java.util.Optional;

import no.ntnu.tdt4100.part2.Person;


/**
 * This interface contains method to work with employees
 * It also contains functionality so that parties interested
 * in being notified when a person is hired or fired are 
 * able to register to recieve notificatons on these events through the {@link IEmployementListener}
 *  
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public interface IHumanResourceManager {

    /**
     * Adds a listener that observes changes to employements (when a person is hired or fired)
     * 
     * The addListener method adds a listener.
     * The same listener can not be added multiple times.
     * 
     * @param listener the {@link IEmployementListener} to add 
     */
    void addListener(IEmployementListener listener);

    /**
     * Removes a previously registered listener.
     * 
     * @param listener the {@link IStockChangeListener} to remove 
     */
    void removeListener(IEmployementListener listener);

    /**
     * Returns the number of added listeners.
     * 
     * @return number of added {@link IEmployementListener} objects
     */
    int getNumberOfListeners();

    /**
     * Hires a person.
     * When a person is hired, trigger all listeners {@link IEmployementListener#trigger(Person, EmploymentStatus)}.
     * 
     * @param person the person to hire
     * @param yearlySalary the persons yearly salary
     * 
     * @throws AlreadyHiredException if this person is already hired
     * @throws ExceedsSingleEmployeeSalaryCapException if this persons salary
     * exceeds the {@link #getSalaryCapForSingleEmployee()}
     * @throws ExceedsSalaryCapForAllEmployeesException if hiring this person would exceed the total salary cap for 
     * this HR manager {@link #getYearlySalaryCap()}
     */
    void hire(Person person, int yearlySalary);

    /**
     * Returns whether the records indicate that the given person is hired
     * @return the whether the records indicate that the given person is hired
     */
    boolean isHired(Person person);

    /**
     * Fires a person.
     * When a person is fired, trigger all listeners {@link IEmployementListener#trigger(Person, EmploymentStatus)}.
     * When a person is fired, a subsequent call to isHired should return false
     * @param person the person to fire
     */
    void fire(Person person);

    /**
     * Returns the number of employees managed by the implementation of this
     * HR manager
     * 
     * @return the number of employees managed by this HR manager
     */
    int getNumberOfEmployees();

    /**
     * Returns the yearly salary cap for the sum of all employees
     * @return the yearly salary cap for the sum of all employees
     */
    int getYearlySalaryCapForAllEmployees();

    /** 
     * Returns the yearly salary cap for a single employee
     * @return the yearly salary cap for a single employee
     */
    int getYearlySalaryCapForSingleEmployee();

    /**
     * Returns the total yearly salary for all hired employees
     * @return the total yearly salary for all hired employees
     */
    int getTotalYearlySalaryForAllEmployees();

    /** 
     * Returns the yearly salary for the given person
     * If this person is not hired at this facility, returns {@link Optional#empty()}
     * @return the yearly salary for the given person
     */
    Optional<Integer> getSalaryFor(Person person);
}
