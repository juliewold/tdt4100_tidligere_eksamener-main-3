package com.mercedesbenz.part2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part2.Project;

@SuppressWarnings("unused")
class ResearchFacilityTests {
    @Test
    void should_be_able_to_instantiate_class_with_constructor() {
        // Uncomment test and remove the assertFalse after implementing the class to run the test
        assertFalse(true);
        // ResearchFacility facility = new ResearchFacility("abc", new ArrayList<Project>(), 10.5);
        // assertNotNull(facility);
    }

    @Test
    void constructor_should_throw_exception_when_name_is_more_than_30_characters() {
         // Uncomment test and remove the assertFalse after implementing the class to run the test
        assertFalse(true);
        // assertThrows(IllegalArgumentException.class, () -> new ResearchFacility("0123456789012345678901234567890", new ArrayList<Project>(), 9.0));
    }

    @Test
    void constructor_should_throw_exception_when_name_is_less_than_3_characters() {
        // Uncomment test and remove the assertFalse after implementing the class to run the test
        assertFalse(true);
        // assertThrows(IllegalArgumentException.class, () -> new ResearchFacility("01", new ArrayList<Project>(), 9.0));
    }

    @Test
    void constructor_should_throw_exception_when_sum_of_projects_is_more_than_facility_budget() {
        // Uncomment test and remove the assertFalse after implementing the class to run the test
        assertFalse(true);
        // assertThrows(IllegalArgumentException.class, () -> new ResearchFacility("abc", List.of(project()), 49.9));
    }

    private Project project() {
        return new Project(UUID.randomUUID(), "abc", 50.0, LocalDate.now(), LocalDate.now());
    }
}
