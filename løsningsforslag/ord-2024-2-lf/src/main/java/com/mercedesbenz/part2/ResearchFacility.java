package com.mercedesbenz.part2;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import no.ntnu.tdt4100.part2.Project;

/**
 * Mercedes has various research facilities around the world.
 * 
 * This class represents a research facility
 */
// TODO Implement the ResearchFacility class and its methods according to JavaDoc
public class ResearchFacility {

    private String name;
    private List<Project> projects;
    private double yearlyBudgetInMillions;

    /**
     * Constructs the research facility object
     * 
     * Behavioural requirements:
     * <ul>
     * <li>The name must be at least 3 characters and at most 30</li>
     * <li>The yearly budget cannot be negative</li>
     * <li>The accumulated sum of budgets in the projects list cannot exceed
     * the yearly budget of the research facility
     * </ul>
     * 
     * @param name                   the name of the research facility, type of {@link String}
     * @param projects               the list of {@link Project} currently in development
     *                               at this research facility
     * @param yearlyBudgetInMillions the yearly budget in millions, type of double
     * @throws IllegalArgumentException if the name is not valid or the yearly
     *                                  budget is negative or the accumulated sum 
     *                                  of budgets in the projects list exceeds the 
     *                                  yearly budget of the facility
     * 
     * @see Project
     */
    public ResearchFacility(String name, List<Project> projects, double yearlyBudgetInMillions) {
        if (name.length() < 3 || 
            name.length() > 30 || 
            yearlyBudgetInMillions < 0.0 ||
            projects.stream().mapToDouble(p -> p.budgetInMillions()).sum() > yearlyBudgetInMillions
        ) throw new IllegalArgumentException();
        this.name = name;
        this.projects = projects;
        this.yearlyBudgetInMillions = yearlyBudgetInMillions;
    }

    /**
     * Returns the name of the research facility
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the yearly budget in millions
     * @return the yearly budget in millions
     */
    public double getYearlyBudgetInMillions() {
        return yearlyBudgetInMillions;
    }

    /**
     * Returns the list of projects currently in development at this research facility
     * 
     * @return the list of projects currently in development at this research facility
     */
    public List<Project> getProjects() {
        return new ArrayList<Project>(projects);
    }

    /**
     * Returns the number of days from today until estimated end time for 
     * the project
     * 
     * If there are no projects at this facility with the given name an empty 
     * Optional should be returned.
     * 
     * @param projectName the name of the project
     * @return an {@link Optional} of type Integer describing the number of days until
     *         estimated end time for the project
     * 
     * @see Project#estimatedEndDate()
     */
    public Optional<Integer> getNumberOfDaysUntilEndTime(String projectName) {
            LocalDate now = LocalDate.now();
            Optional<Project> end = this.projects.stream()
                .filter(p->p.name().equals(projectName)).findAny();
            if (!end.isPresent()) return Optional.empty();
            LocalDate endDate = end.get().estimatedEndDate();
            long days = now.until(endDate, ChronoUnit.DAYS);
            return Optional.of((int)days);
    }
}