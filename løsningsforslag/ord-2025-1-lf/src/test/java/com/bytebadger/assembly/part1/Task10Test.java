package com.bytebadger.assembly.part1;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class Task10Test {
    @Test
    void testEmployeeSorterReturnsList() {
        EmployeeSorter sorter = new EmployeeSorter();
        List<Employee> employees = List.of(
            new Employee("Alice", 3),
            new Employee("Bob", 1),
            new Employee("Charlie", 2)
        );
        Collection<Employee> sorted = sorter.sortEmployees(employees);
        assertTrue(sorted instanceof List, "Expected a List as the return type");
    }

    @Test
    void testSortEmployeesByLastLetterAndEmployeeId() {
        EmployeeSorter sorter = new EmployeeSorter();
        List<Employee> employees = List.of(
            new Employee("Alice", 3),
            new Employee("Dave", 4),
            new Employee("Bob", 5),
            new Employee("Charlie", 2)
        );
        
        Collection<Employee> returned = sorter.sortEmployees(employees);
        assumeTrue(returned instanceof List, "Expected a List as the return type");
        List<Employee> sorted = (List<Employee>) returned;
        
        // Sorted by last letter: Alice(e), Dave(e), Charlie(e), Bob(b)
        assertEquals("Bob", sorted.get(0).getName());
        assertEquals("Charlie", sorted.get(1).getName());
        assertEquals("Alice", sorted.get(2).getName());
        assertEquals("Dave", sorted.get(3).getName());
    }

    @Test
    void testEmployeeWithIdZeroIsKept() {
        EmployeeSorter sorter = new EmployeeSorter();
        Employee zeroId = new Employee("Eve", 0);
        List<Employee> employees = List.of(
            new Employee("Alice", 3),
            zeroId,
            new Employee("Bob", 1)
        );
        Collection<Employee> sorted = sorter.sortEmployees(employees);
        assertTrue(sorted.contains(zeroId), "Employee with ID 0 should be present in the sorted list");
    }
}
