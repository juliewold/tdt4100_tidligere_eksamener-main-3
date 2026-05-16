package no.ntnu.tdt4100.part2;

import java.util.List;
import java.util.Optional;

/**
 * The <code>IGroupHeadquarters</code> interface contains methods that 
 * the Mercedes Group Head quarters use regularly.
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public interface IGroupHeadquarters {

    /**
     * Returns the total budget for all research facilities 
     * rounded up to nearest whole number.
     *
     * @param facilities the research facilities
     * @return an {@link Integer} as the total budget for all facilities
     *         rounded up to nearest whole number
     * 
     * @see IResearchFacility#getYearlyBudgetInMillions()
     */
    Integer getTotalBudgetForAllFacilities(List<IResearchFacility> facilities);


    /**
     * Given a list of randomly added research facilities, returns
     * a list of alphabetically sorted research facilities by their name. 
     *
     * @param facilities
     * @return a list of research facilities alphabetically sorted by their names
     */
    List<IResearchFacility> sortFacilities(List<IResearchFacility> facilities);


    /**
     * Returns the {@link Project} with the highest budget across all supplied research facilities.
     * If there are multiple Projects with the same budget, return either.
     * 
     * If no facilities are supplied or the facilities have no projects, return {@link Optional#empty()}
     * 
     * @param facilities
     * @return the most expensive project across all given research facilities
     * 
     * @see Project#budgetInMillions()
     */
    Optional<Project> getMostExpensiveProject(List<IResearchFacility> facilities);


    /**
     * Returns the research facilities that have at least 3 projects 
     * with a budget equal to or larger than the given budget filter.
     * If no research facility fulfills that requirement, return an empty list.
     * 
     * If the budget filter parameter is <code>null</code>, return all facilities.
     *  
     * @param facilities the list of car factories to filter
     * @param budgetFilter the lowpass budget filter in millions
     * @return a list of research facilities that have at least 3 projects with a budget
     * equal to or larger than the given budget filter.
     */
    List<IResearchFacility> filterFacilities(List<IResearchFacility> facilities, Double budgetFilter);        
}
