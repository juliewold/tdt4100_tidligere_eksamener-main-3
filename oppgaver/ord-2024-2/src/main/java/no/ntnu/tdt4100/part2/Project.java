package no.ntnu.tdt4100.part2;

import java.time.LocalDate;
import java.util.UUID;

/** 
 * This is a supplied class 
 * DO NOT MODIFY THIS CODE
 * */
public record Project(  
                        UUID projectId,
                        String name, 
                        double budgetInMillions,
                        LocalDate startDate,
                        LocalDate estimatedEndDate
) { }

