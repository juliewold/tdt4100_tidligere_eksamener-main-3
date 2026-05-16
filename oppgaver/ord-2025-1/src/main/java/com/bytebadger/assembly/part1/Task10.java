package com.bytebadger.assembly.part1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;


class Employee {
    private final String name;
    private final int employeeId;

    public Employee(String name, int employeeId) {
        if (name == null || employeeId < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.employeeId = employeeId;
    }
    public String getName() { return name; }
    public int getEmployeeId() { return employeeId; }
}


class EmployeeSorter {
    /**
     * Sort the employees by the last letter of their name (a–z).
     * If multiple employees have the same last letter, 
     * sort them by their employeeId from lowest to highest.
     * 
     * @param employees the list of Employee objects to sort
     * @return a sorted collection of Employee objects
     */
    
    public Collection<Employee> sortEmployees(List<Employee> employees) {

        // TODO: Implement the sorting logic here, by uncommenting appropriate lines.
        
        // NB! You are not allowed to rearrange lines, only uncomment specific lines.
        
        return employees
            .stream()
            // .filter(e -> e.getEmployeeId() > 0)
            .sorted(Comparator.comparing(Employee::getEmployeeId))
            // .sorted(Comparator.comparing(Employee::getName))
            // .sorted(Comparator.comparingInt(e -> e.getName().charAt(0)))
            .sorted(Comparator.comparingInt(e -> e.getName().charAt(e.getName().length() - 1)))
            // .sorted(Comparator.comparingInt(Employee::getEmployeeId))
            // .forEach(System.out::println)
            // .collect(Collectors.toSet())
            .collect(Collectors.toList())
            ;
    
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Per", 2);
        Employee employee2 = new Employee("Ada", 3);
        Employee employee3 = new Employee("Emma", 1);

        List<Employee> employees = Arrays.asList(employee, employee2, employee3);
        EmployeeSorter employeeSorter = new EmployeeSorter();
        Collection<Employee> sortedList = employeeSorter.sortEmployees(employees);
        for (Employee e : sortedList) {
            System.out.println(e.getName() + " " + e.getEmployeeId());
        }
    }

}

