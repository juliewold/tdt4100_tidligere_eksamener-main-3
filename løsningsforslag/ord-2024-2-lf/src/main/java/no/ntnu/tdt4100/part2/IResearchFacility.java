package no.ntnu.tdt4100.part2;

import java.util.List;

/**
 * The <code>IMainOffice</code> interface contains methods that the BMW main office needs.
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public interface IResearchFacility {
    String getName();
    double getYearlyBudgetInMillions();
    List<Project> getProjects();
}


