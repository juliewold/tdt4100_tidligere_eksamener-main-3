package com.mercedesbenz.part2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part2.IGroupHeadquarters;
import no.ntnu.tdt4100.part2.IResearchFacility;
import no.ntnu.tdt4100.part2.Project;

@SuppressWarnings("unused")
class GroupHeadquartersTests {
    

    IResearchFacility facility1;
    IResearchFacility facility2;
    IResearchFacility facility3;
    List<IResearchFacility> facilities;

    @BeforeEach
    void setup() {

        facility1 = mock();
        facility2 = mock();
        facility3 = mock();
        
        when(facility1.getName()).thenReturn("ZZZ");
        when(facility1.getYearlyBudgetInMillions()).thenReturn(0.9);
        when(facility1.getProjects()).thenReturn(List.of(project(10), project(20), project(21)));
        
        when(facility2.getName()).thenReturn("MMM");
        when(facility2.getProjects()).thenReturn(List.of(project(20), project(21)));

        when(facility3.getName()).thenReturn("AAA");
        when(facility3.getProjects()).thenReturn(List.of(project(20), project(21), project(22)));

        // Use the below list to test the other implemented methods in GroupHeadquarters
        facilities = List.of(facility1, facility2, facility3);
    }

    private Project project(double budget) {
        return new Project(UUID.randomUUID(), "abc", budget, LocalDate.now(), LocalDate.now());
    }

    @Test
    void GroupHeadquarters_implements_the_IGroupHeadquarters_interface() {
        Type[] ifaces = GroupHeadquarters.class.getGenericInterfaces();
        assertEquals(1, ifaces.length);
        assertEquals(IGroupHeadquarters.class.getName(), ifaces[0].getTypeName());
    }

    @Test
    void getTotalBudgetForAllFacilities_should_return_correct_result() {
        IResearchFacility facility1 = mock();
        IResearchFacility facility2 = mock();
        when(facility1.getYearlyBudgetInMillions()).thenReturn(0.9);
        when(facility2.getYearlyBudgetInMillions()).thenReturn(0.9);

        GroupHeadquarters g = new GroupHeadquarters();

        // Uncomment this test, remove the assertFalse, and run the test after implementing the interface
        assertFalse(true);
        // assertEquals(2, g.getTotalBudgetForAllFacilities(List.of(facility1,facility2)));
    }
}
