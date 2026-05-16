package com.mercedesbenz.part5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part2.IResearchFacility;
import no.ntnu.tdt4100.part2.Person;
import no.ntnu.tdt4100.part2.Project;
import no.ntnu.tdt4100.part2.Role;
import no.ntnu.tdt4100.part5.CanNotStartProjectException;
import no.ntnu.tdt4100.part5.IHasHumanResourceManager;
import no.ntnu.tdt4100.part5.IHumanResourceManager;

class ResearchFacilityWithHrManagerTests {
    
    IHumanResourceManager humanResourceManager;
    ResearchFacilityWithHrManager researchFacilityWithHrManager;
    IResearchFacility delegate;
    Person person1;
    Person person2;
    Person person3;
    Project project1;
    Project project2;

    @BeforeEach
    void before() {
        delegate = mock();
        humanResourceManager = mock();

        person1 = new Person("a", Role.RESEARCHER);
        person2 = new Person("b", Role.RESEARCHER);
        person3 = new Person("c", Role.RESEARCHER);

        project1 = new Project(UUID.randomUUID(), "a", 10, LocalDate.now(), LocalDate.now());

        researchFacilityWithHrManager = new ResearchFacilityWithHrManager(delegate, humanResourceManager);
    }


    @Test
    void ResearchFacilityWithHrManager_class_should_implement_IResearchFacility_interface() {
        assertTrue(Arrays.stream(ResearchFacilityWithHrManager.class.getGenericInterfaces())
        .anyMatch(x -> x.getTypeName().equals(IResearchFacility.class.getName())));
    }

    @Test
    void ResearchFacilityWithHrManager_class_should_implement_IHumanResourceManager_interface() {
        assertTrue(Arrays.stream(ResearchFacilityWithHrManager.class.getGenericInterfaces())
        .anyMatch(x -> x.getTypeName().equals(IHasHumanResourceManager.class.getName())));
    }


    @Test 
    void startProject_should_throw_CanNotStartProjectException_if_a_person_exceeds_yearlySalaryCapForSingleEmployee() {
        int YEARLY_SALARY_CAP_FOR_SINGLE_EMPLOYEE = 10;
        int YEARLY_SALARY_PERSON = 11;
        when(humanResourceManager.getYearlySalaryCapForSingleEmployee()).thenReturn(YEARLY_SALARY_CAP_FOR_SINGLE_EMPLOYEE);

        assertThrows(CanNotStartProjectException.class, () -> researchFacilityWithHrManager.startProject(project1, Map.of(person1, YEARLY_SALARY_PERSON)));
        verify(humanResourceManager, atLeast(1)).getYearlySalaryCapForSingleEmployee();
    }

    @Test 
    void startProject_should_throw_CanNotStartProjectException_if_hiring_people_exceeds_yearlySalaryCapForAllEmployees() {
        int YEARLY_SALARY_CAP_FOR_ALL_EMPLOYES = 10;
        int YEARLY_SALARY_PERSON = 4;
        when(humanResourceManager.getYearlySalaryCapForAllEmployees()).thenReturn(YEARLY_SALARY_CAP_FOR_ALL_EMPLOYES);

        assertThrows(CanNotStartProjectException.class, () -> 
        researchFacilityWithHrManager.startProject(project1, 
                Map.of(person1, YEARLY_SALARY_PERSON, person2, YEARLY_SALARY_PERSON, person3, YEARLY_SALARY_PERSON)));
        verify(humanResourceManager, atLeast(1)).getTotalYearlySalaryForAllEmployees();
    }

    @Test 
    void startProject_should_throw_CanNotStartProjectException_if_any_in_list_is_already_hired() {
        when(humanResourceManager.getYearlySalaryCapForSingleEmployee()).thenReturn(Integer.MAX_VALUE);
        when(humanResourceManager.getYearlySalaryCapForAllEmployees()).thenReturn(Integer.MAX_VALUE);
        when(humanResourceManager.isHired(person3)).thenReturn(true);

        assertThrows(CanNotStartProjectException.class, () -> 
        researchFacilityWithHrManager.startProject(project1, 
                Map.of(person1, 1, person2, 1, person3, 1)));
        verify(humanResourceManager, atLeast(1)).isHired(person3);
    }

    @Test 
    void startProject_should_add_project_to_list_of_projects_if_project_starts() throws CanNotStartProjectException {
        when(humanResourceManager.getYearlySalaryCapForSingleEmployee()).thenReturn(Integer.MAX_VALUE);
        when(humanResourceManager.getYearlySalaryCapForAllEmployees()).thenReturn(Integer.MAX_VALUE);
        when(delegate.getProjects()).thenReturn(new ArrayList<Project>());

        researchFacilityWithHrManager.startProject(project1, Map.of(person1, 1, person2, 1, person3, 1));
        assertEquals(1, researchFacilityWithHrManager.getProjects().size());
        assertEquals(1, delegate.getProjects().size());
    }

    @Test 
    void startProject_should_hire_all_people_if_project_starts() throws CanNotStartProjectException {
        when(humanResourceManager.getYearlySalaryCapForSingleEmployee()).thenReturn(Integer.MAX_VALUE);
        when(humanResourceManager.getYearlySalaryCapForAllEmployees()).thenReturn(Integer.MAX_VALUE);

        researchFacilityWithHrManager.startProject(project1, Map.of(person1, 1, person2, 1, person3, 1));
        verify(humanResourceManager, times(1)).hire(person1, 1);
        verify(humanResourceManager, times(1)).hire(person2, 1);
        verify(humanResourceManager, times(1)).hire(person3, 1);
    }


    @Test 
    void endProject_should_remove_project_from_list_of_projects() throws CanNotStartProjectException {
        List<Project> list = new ArrayList<>();
        list.add(project1);
        when(delegate.getProjects()).thenReturn(list);
        researchFacilityWithHrManager.endProject(project1.projectId(), List.of(person1));

        assertEquals(0, researchFacilityWithHrManager.getProjects().size());
        assertEquals(0, delegate.getProjects().size());
    }


    @Test 
    void endProject_should_do_nothing_if_project_is_not_in_the_list_of_projects() throws CanNotStartProjectException {
        List<Project> list = new ArrayList<>();
        list.add(project1);
        when(delegate.getProjects()).thenReturn(list);
        researchFacilityWithHrManager.endProject(UUID.randomUUID(), List.of(person1));

        assertEquals(1, researchFacilityWithHrManager.getProjects().size());
        assertEquals(1, delegate.getProjects().size());
        verify(humanResourceManager, times(0)).fire(person1);
    }

    @Test 
    void endProject_should_fire_people_when_project() throws CanNotStartProjectException {
        List<Project> list = new ArrayList<>();
        list.add(project1);
        when(delegate.getProjects()).thenReturn(list);
        researchFacilityWithHrManager.endProject(project1.projectId(), List.of(person1, person2));

        assertEquals(0, researchFacilityWithHrManager.getProjects().size());
        verify(humanResourceManager, times(1)).fire(person1);
        verify(humanResourceManager, times(1)).fire(person2);
    }
   

    @Test
    void getHumanResourceManager_should_not_be_null() {
        assertFalse(true);
        assertNotNull(researchFacilityWithHrManager.getHumanResourceManager());
        assertEquals(researchFacilityWithHrManager, researchFacilityWithHrManager.getHumanResourceManager());
    }


    @Test
    void methods_from_the_delegate_IResearchFacility_added_in_the_constructor_should_be_called_when_calling_some_methods() {
        String EXPECTED_NAME = "ABC";
        double EXPECTED_YEARLY_BUDGET_IN_MILLIONS = 20.0;
        List<Project> EXPECTED_LIST_OF_PROJECTS = List.of(new Project(UUID.randomUUID(), EXPECTED_NAME, EXPECTED_YEARLY_BUDGET_IN_MILLIONS, LocalDate.of(2024, 01, 01), LocalDate.of(2026, 01, 01)));
     
        // setup what the delegate should return when called
        when(delegate.getName()).thenReturn(EXPECTED_NAME);
        when(delegate.getYearlyBudgetInMillions()).thenReturn(EXPECTED_YEARLY_BUDGET_IN_MILLIONS);
        when(delegate.getProjects()).thenReturn(EXPECTED_LIST_OF_PROJECTS);
    
        // call CarFactoryWithInventory and verify that it calls the delegate and returns values from the delegate
        assertEquals(EXPECTED_NAME, researchFacilityWithHrManager.getName());
        assertEquals(EXPECTED_YEARLY_BUDGET_IN_MILLIONS, researchFacilityWithHrManager.getYearlyBudgetInMillions());
        assertEquals(EXPECTED_LIST_OF_PROJECTS.get(0).projectId(), researchFacilityWithHrManager.getProjects().get(0).projectId());
        verify(delegate, times(1)).getName();
        verify(delegate, times(1)).getYearlyBudgetInMillions();
        verify(delegate, times(1)).getProjects();
    }
}