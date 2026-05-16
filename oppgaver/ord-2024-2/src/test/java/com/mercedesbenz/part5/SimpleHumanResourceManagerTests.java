package com.mercedesbenz.part5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part2.Person;
import no.ntnu.tdt4100.part2.Role;
import no.ntnu.tdt4100.part5.AlreadyHiredException;
import no.ntnu.tdt4100.part5.EmploymentStatus;
import no.ntnu.tdt4100.part5.ExceedsSalaryCapForAllEmployeesException;
import no.ntnu.tdt4100.part5.ExceedsSingleEmployeeSalaryCapException;
import no.ntnu.tdt4100.part5.IEmployementListener;
import no.ntnu.tdt4100.part5.IHumanResourceManager;

class SimpleHumanResourceManagerTests {

    private IHumanResourceManager manager;
    private IEmployementListener listener1;
    private IEmployementListener listener2;
    private Person person;

    @BeforeEach
    void setup() {
        listener1 = mock();
        listener2 = mock();

        manager = new SimpleHumanResourceManager(0, 0);
        assertFalse(true);
        person = new Person("a", Role.DEPARTMENT_LEAD);
    }

    @Test
    void SimpleHumanResourceManager_class_should_only_implement_IHumanResourceManager_interface() {
        assertEquals(IHumanResourceManager.class.getName(),
                SimpleHumanResourceManager.class.getGenericInterfaces()[0].getTypeName());
    }

    @Test
    void getYearlySalaryCapForAllEmployees_should_return_the_cap() {
        final int EXPECTED_SALARY_CAP_ALL_EMPLOYEES = 10000;
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(EXPECTED_SALARY_CAP_ALL_EMPLOYEES, 0);
        assertEquals(EXPECTED_SALARY_CAP_ALL_EMPLOYEES, manager.getYearlySalaryCapForAllEmployees());
    }

    @Test
    void getYearlySalaryCapForSingleEmployees_should_return_the_cap() {
        final int EXPECTED_SALARY_CAP_SINGLE_EMPLOYEE = 10000;
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(0, EXPECTED_SALARY_CAP_SINGLE_EMPLOYEE);
        assertEquals(EXPECTED_SALARY_CAP_SINGLE_EMPLOYEE, manager.getYearlySalaryCapForSingleEmployee());
    }

    @Test
    void addListener_adding_same_listener_multiple_times_should_not_increase_number_of_listeners() {
        manager.addListener(listener1);
        manager.addListener(listener1);
        assertEquals(1, manager.getNumberOfListeners());
    }

    @Test
    void addListener_when_adding_two_different_listeners_number_of_listeners_should_be_two() {
        manager.addListener(listener1);
        manager.addListener(listener2);
        assertEquals(2, manager.getNumberOfListeners());
    }

    @Test
    void removeListener_when_removing_a_nonexistent_listener_number_of_listeners_should_be_zero() {
        manager.removeListener(listener1);
        assertEquals(0, manager.getNumberOfListeners());
    }

    @Test
    void removeListener_when_removing_existing_listener_number_of_listeners_should_decrease() {
        manager.addListener(listener1);
        assertEquals(1, manager.getNumberOfListeners());
        manager.removeListener(listener1);
        assertEquals(0, manager.getNumberOfListeners());
    }

    @Test
    void removeListener_when_removing_same_listener_2_times_number_should_not_change() {
        manager.addListener(listener1);
        manager.removeListener(listener1);
        assertEquals(0, manager.getNumberOfListeners());
        manager.removeListener(listener1);
        assertEquals(0, manager.getNumberOfListeners());
    }

    @Test
    void removeListener_when_removing_listener_which_is_not_listening_number_of_listeners_should_not_change() {
        manager.addListener(listener1);
        assertEquals(1, manager.getNumberOfListeners());
        manager.removeListener(listener2);
        assertEquals(1, manager.getNumberOfListeners());
    }

    @Test
    void hire_when_yearly_salary_cap_for_single_employee_is_exceeded_throws_ExceedsSingleEmployeeSalaryCap() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(0, 10);
        assertThrows(ExceedsSingleEmployeeSalaryCapException.class, () -> manager.hire(person, 11));
    }

    @Test
    void hire_when_yearly_salary_cap_for_all_employees_is_exceeded_throws_ExceededSalaryCapForSingleEmployeeException() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        assertThrows(ExceedsSalaryCapForAllEmployeesException.class, () -> manager.hire(person, 11));
    }

    @Test
    void hire_when_person_already_hired_throws_AlreadyHiredException() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        manager.hire(person, 1);
        assertThrows(AlreadyHiredException.class, () -> manager.hire(person, 1));
    }

    @Test
    void hire_when_hire_2_getNumberOfEmployees_should_be_2() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        manager.hire(person, 1);
        manager.hire(new Person("c", Role.FACILITY_MANAGER), 1);
        assertEquals(2, manager.getNumberOfEmployees());
    }

    @Test
    void hire_when_not_hired_a_person_should_not_trigger_listeners() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        Person person = new Person("c", Role.FACILITY_MANAGER);
        doNothing().when(listener1).trigger(person, EmploymentStatus.HIRED);
        manager.addListener(listener1);
        assertThrows(Exception.class, () -> manager.hire(person, 12));
        assertEquals(0, manager.getNumberOfEmployees());
        verify(listener1, times(0)).trigger(person, EmploymentStatus.HIRED);
    }

    @Test
    void isHired_should_return_false_when_person_is_not_hired() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        Person person = new Person("c", Role.FACILITY_MANAGER);
        assertFalse(manager.isHired(person));
    }

    @Test
    void isHired_should_return_true_when_person_is_hired() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        Person person = new Person("c", Role.FACILITY_MANAGER);
        manager.hire(person, 10);
        assertTrue(manager.isHired(person));
    }

    @Test
    void hire_when_hire_a_person_should_trigger_listeners() {

        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        Person person = new Person("c", Role.FACILITY_MANAGER);
        doNothing().when(listener1).trigger(person, EmploymentStatus.HIRED);
        manager.addListener(listener1);
        manager.hire(person, 1);
        assertEquals(1, manager.getNumberOfEmployees());
        verify(listener1, times(1)).trigger(person, EmploymentStatus.HIRED);
    }

    @Test
    void fire_when_fire_a_person_who_is_not_hired_should_not_trigger_listeners() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        doNothing().when(listener1).trigger(any(Person.class), any());
        manager.addListener(listener1);
        manager.fire(new Person("c", Role.FACILITY_MANAGER));
        verify(listener1, times(0)).trigger(any(Person.class), any());
        ;
    }

    @Test
    void fire_when_fire_a_person_who_is_hired_should_trigger_listeners() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        Person person = new Person("c", Role.FACILITY_MANAGER);
        doNothing().when(listener1).trigger(person, EmploymentStatus.FIRED);
        doNothing().when(listener1).trigger(person, EmploymentStatus.HIRED);
        manager.addListener(listener1);

        manager.hire(person, 1);
        manager.fire(person);
        verify(listener1, times(1)).trigger(person, EmploymentStatus.FIRED);
    }

    @Test
    void getTotalYearlySalary_when_hired_2_should_return_sum_of_yearly_salaries_for_all_hired() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        manager.hire(person, 1);
        manager.hire(new Person("c", Role.FACILITY_MANAGER), 3);
        assertEquals(4, manager.getTotalYearlySalaryForAllEmployees());
    }

    @Test
    void getTotalYearlySalary_should_return_0_when_none_hired() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        assertEquals(0, manager.getTotalYearlySalaryForAllEmployees());
    }

    @Test
    void getSalaryFor_should_return_correct_result() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        Person person = new Person("c", Role.FACILITY_MANAGER);
        manager.hire(person, 3);
        assertEquals(3, manager.getSalaryFor(person).get());
    }

    @Test
    void getSalaryFor_should_return_empty_when_person_is_null() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        assertFalse(manager.getSalaryFor(null).isPresent());
    }

    @Test
    void getSalaryFor_should_return_empty_when_person_is_not_hired() {
        SimpleHumanResourceManager manager = new SimpleHumanResourceManager(10, 11);
        assertFalse(manager.getSalaryFor(person).isPresent());
    }
}
