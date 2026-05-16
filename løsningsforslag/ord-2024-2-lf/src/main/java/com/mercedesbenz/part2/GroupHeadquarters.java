package com.mercedesbenz.part2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import no.ntnu.tdt4100.part2.IGroupHeadquarters;
import no.ntnu.tdt4100.part2.IResearchFacility;
import no.ntnu.tdt4100.part2.Project;

/**
 * Implement the class GroupHeadquarters
 * 
 * The class must implement the interface {@link no.ntnu.tdt4100.part2.IGroupHeadquarters}. 
 */
public class GroupHeadquarters implements IGroupHeadquarters{

    @Override
    public Integer getTotalBudgetForAllFacilities(List<IResearchFacility> facilities) {
        return (int) Math.ceil(facilities.stream().mapToDouble(m -> m.getYearlyBudgetInMillions()).sum());
    }

    @Override
    public List<IResearchFacility> sortFacilities(List<IResearchFacility> facilities) {
        return facilities.stream().sorted((f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName())).toList();
    }

    @Override
    public Optional<Project> getMostExpensiveProject(List<IResearchFacility> facilities) {
        return facilities.stream()
                    .map(f -> f.getProjects()).flatMap(f -> f.stream())
                    .sorted(Collections.reverseOrder(Comparator.comparingDouble(Project::budgetInMillions))).findFirst();
    }

    @Override
    public List<IResearchFacility> filterFacilities(List<IResearchFacility> facilities, Double budgetFilter) {
        if (budgetFilter == null) return facilities;

        return facilities.stream()
            .filter(x -> x.getProjects()
                            .stream()
                            .filter(p -> p.budgetInMillions() >= budgetFilter).count() >= 3)
            .toList();
    }
    // TODO Implement the class
}
