package model.controller;

import model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeController {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 25, 50000, "HR"),
                new Employee(2, "Jane Smith", 35, 60000, "Finance"),
                new Employee(3, "Alice Johnson", 28, 70000, "IT"),
                new Employee(4, "Bob Brown", 45, 120000, "Finance"),
                new Employee(5, "Charlie Davis", 30, 90000, "IT"),
                new Employee(6, "Diana Green", 50, 130000, "HR"),
                new Employee(7, "Eve White", 40, 95000, "Finance"),
                new Employee(8, "Frank Black", 32, 85000, "IT"),
                new Employee(9, "Grace Hall", 29, 40000, "HR"),
                new Employee(10, "Hank King", 31, 75000, "IT"),
                new Employee(11, "Ivy Lewis", 38, 65000, "Finance"),
                new Employee(12, "Jack Young", 42, 110000, "HR"),
                new Employee(13, "Kara Knight", 26, 50000, "IT"),
                new Employee(14, "Leo Turner", 33, 80000, "Finance"),
                new Employee(15, "Mia Baker", 37, 70000, "IT"),
                new Employee(16, "Noah Wilson", 34, 90000, "Finance"),
                new Employee(17, "Olivia Moore", 27, 65000, "HR"),
                new Employee(18, "Paul Harris", 41, 100000, "IT"),
                new Employee(19, "Quinn Carter", 36, 75000, "Finance"),
                new Employee(20, "Ryan Adams", 39, 105000, "HR")
        );

    /*
    Simple Filtering: Given a list of employees, filter out the employees who are older
    than 30 years. Collect the results into a new list and print it.
     */
        long employeeAgeGreaterThan30 = employees.stream()
                .filter(age -> age.getAge() > 30)
                .count();

        System.out.println(employeeAgeGreaterThan30);

        /*
        Mapping and Collecting: Given a list of employees,
        extract the names of all employees into a list of strings.
        Print the list of names.
         */
        List<String> empNames = employees.stream()
                .map(name -> name.getName()).collect(Collectors.toList());

//        empNames.stream().forEach(name -> System.out.print(name + " "));

        Map<String, List<Employee>> groupByEmpDept = employees.stream()
                .collect(Collectors.groupingBy(dept -> dept.getDepartment()));

        groupByEmpDept.forEach((department, count) -> System.out.println(department + " " + count));

        boolean anyHigherEarnings = employees.stream().anyMatch(salary -> salary.getSalary() > 100000);
        System.out.println(anyHigherEarnings);

        Map<String, Double> collected = employees
                .stream()
                .collect(
                        Collectors.groupingBy(dept -> dept.getDepartment(),
                                Collectors.averagingDouble(avgSalary -> avgSalary.getSalary())));

        collected.forEach((dept, avgSalary) -> System.out.println(dept + " " + avgSalary));
    }

}
