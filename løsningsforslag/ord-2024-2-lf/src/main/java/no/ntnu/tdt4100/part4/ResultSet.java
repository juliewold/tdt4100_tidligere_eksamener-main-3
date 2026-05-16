package no.ntnu.tdt4100.part4;

import java.util.Set;

import no.ntnu.tdt4100.part2.Project;

/**
 * The <code>ResultSet</code> record contains a {@link Set} of projects and a {@link Set} of {@link LineReadError}
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public record ResultSet(Set<Project> projects, Set<LineReadError> errors) {
    public LineReadError getError(int lineNumber) {
        return errors.stream().filter(x -> x.lineNumber() == lineNumber).findFirst().get();
    }
}

