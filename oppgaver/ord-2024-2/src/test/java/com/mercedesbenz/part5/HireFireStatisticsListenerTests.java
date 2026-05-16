package com.mercedesbenz.part5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part2.Person;
import no.ntnu.tdt4100.part2.Role;
import no.ntnu.tdt4100.part5.EmploymentStatus;
import no.ntnu.tdt4100.part5.IEmployementListener;

@SuppressWarnings("unused")
class HireFireStatisticsListenerTests {

    HireFireStatisticsListener listener;

    @BeforeEach
    void setup() {
        listener = new HireFireStatisticsListener();
    }

    @Test
    void HireFireStatisticsListener_class_should_only_implement_IHumanResourceManager_interface() {
        assertEquals(IEmployementListener.class.getName(),
                HireFireStatisticsListener.class.getGenericInterfaces()[0].getTypeName());
    }

    @Test
    void HireFireStatisticsListener_class_should_have_no_declared_constructors() {
        assertEquals(1, HireFireStatisticsListener.class.getDeclaredConstructors().length);
        assertEquals(0, HireFireStatisticsListener.class.getDeclaredConstructors()[0].getParameterCount());
        assertFalse(Modifier.isPrivate(HireFireStatisticsListener.class.getDeclaredConstructors()[0].getModifiers()));
    }

    @Test
    void getNumberOfHiredPeople_should_return_0_when_trigger_method_is_not_invoked() {
        assertEquals(0, listener.getNumberOfHiredPeople(Role.DEPARTMENT_LEAD));
    }

    @Test
    void getNumberOfHiredPeople_should_return_0_when_trigger_is_invoked_with_EmployementStatus_FIRED() {
        listener.trigger(new Person("a", Role.FACILITY_MANAGER), EmploymentStatus.FIRED);
        assertEquals(0, listener.getNumberOfHiredPeople(Role.FACILITY_MANAGER));
    }

    @Test
    void getNumberOfHiredPeople_should_return_0_when_trigger_method_is_invoked_with_NULL() {
        listener.trigger(null, EmploymentStatus.FIRED);
        assertEquals(0, listener.getNumberOfHiredPeople(Role.DEPARTMENT_LEAD));
    }

    @Test
    void getNumberOfHiredPeople_should_return_1_when_trigger_is_invoked_with_EmployementStatus_HIRED() {
        listener.trigger(new Person("a", Role.FACILITY_MANAGER), EmploymentStatus.HIRED);
        assertEquals(1, listener.getNumberOfHiredPeople(Role.FACILITY_MANAGER));
    }

    @Test
    void getNumberOfHiredPeople_should_return_2_when_trigger_is_invoked_twice_even_when_fired_invoked_between_hirings() {
        Person person = new Person("a", Role.FACILITY_MANAGER);
        listener.trigger(person, EmploymentStatus.HIRED);
        listener.trigger(person, EmploymentStatus.FIRED);
        listener.trigger(person, EmploymentStatus.HIRED);
        assertEquals(2, listener.getNumberOfHiredPeople(Role.FACILITY_MANAGER));
    }

    @Test
    void getNumberOfHiredPeople_should_return_number_of_hired_for_a_role() {

        for (int i = 0; i < 3; i++) {
            listener.trigger(new Person("a" + i, Role.FACILITY_MANAGER), EmploymentStatus.HIRED);
        }
        
        for (int i = 0; i < 10; i++) {
            listener.trigger(new Person("a" + i, Role.RESEARCHER), EmploymentStatus.HIRED);
        }

        int numberOfHiredFacilityManagersAfterTrigger = listener.getNumberOfHiredPeople(Role.FACILITY_MANAGER);
        assertEquals(3, numberOfHiredFacilityManagersAfterTrigger);
        int numberOfHiredResearchersAfterTrigger = listener.getNumberOfHiredPeople(Role.RESEARCHER);
        assertEquals(10, numberOfHiredResearchersAfterTrigger);
        assertEquals(3, listener.getNumberOfHiredPeople(Role.FACILITY_MANAGER));
        assertEquals(0, listener.getNumberOfHiredPeople(Role.DEPARTMENT_LEAD));
    }

    @Test
    void getNumberOfFiredPeople_should_return_0_if_trigger_hasnt_been_called() {
        HireFireStatisticsListener listener = new HireFireStatisticsListener();

        assertEquals(0, listener.getNumberOfHiredPeople(Role.FACILITY_MANAGER));
        assertEquals(0, listener.getNumberOfHiredPeople(Role.DEPARTMENT_LEAD));
    }
}
