package com.mercedesbenz.part2;

/**
 * Mercedes has various research facilities around the world.
 * 
 * This class represents a research facility
 */
// TODO Implement the ResearchFacility class and its methods according to JavaDoc

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
    // TODO Implement the constructor

    /**
     * Returns the name of the research facility
     * @return the name of the research facility, type of {@link String}
     */
    // TODO Implement the getName() method

    /**
     * Returns the yearly budget in millions
     * @return the yearly budget in millions
     */
    // TODO Implement the getYearlyBudgetInMillions() method, type of double

    /**
     * Returns the list of projects currently in development at this research facility
     * 
     * @return the list of projects currently in development at this research facility
     */
    // TODO Implement the getProjects() method according to JavaDoc

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
    // TODO Implement the getNumberOfDaysUntilEndTime method according to JavaDoc
