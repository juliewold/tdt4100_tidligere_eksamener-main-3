package com.mercedesbenz.part4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part2.Project;
import no.ntnu.tdt4100.part4.ResultSet;

public class ProjectsReaderTests {

    @Test
    public void readProjects_resultSet_errors_should_contain_duplicate_projects() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("data.csv")) {
            ResultSet resultSet = ProjectsReader.readProjects(s);

            assertEquals("Duplicate project", 
            resultSet.getError(23).errorMessage(),
            "The project on line 23 is duplicate because the project on line 22 is the same"
            );
            assertEquals("Duplicate project", 
                resultSet.getError(295).errorMessage(), 
            "The project on line 295 is duplicate because the project on line 294 is the same");
        }
    }

    @Test
    public void readProjects_should_produce_correct_results() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("data.csv")) {
            ResultSet resultSet = ProjectsReader.readProjects(s);
            Project p = resultSet.projects().stream().filter(x -> UUID.fromString("98e0b018-fbee-4625-86e4-55fac01c57fe").equals(x.projectId())).findFirst().orElse(null);
            
            assertEquals("Multi-tiered logistical collaboration", p.name());
            assertEquals(153.5, p.budgetInMillions());
            assertEquals(LocalDate.of(2017, 7, 10), p.startDate());
            assertEquals(LocalDate.of(2027, 11, 14), p.estimatedEndDate());
        }
    }

    @Test
    public void readProjects_should_return_correct_number_of_elements() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("data.csv")) {
            ResultSet resultSet = ProjectsReader.readProjects(s);

            assertEquals(294, resultSet.projects().size());
        }
    }

    @Test
    public void readProjects_should_have_7_errors() throws IOException {
        try (InputStream s = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("data.csv")) {
            ResultSet resultSet = ProjectsReader.readProjects(s);

            assertEquals(7, resultSet.errors().size(),
            "The errors are on line 23, 24, 25, 26, 27, 28 and 295");
        }
    }
}
