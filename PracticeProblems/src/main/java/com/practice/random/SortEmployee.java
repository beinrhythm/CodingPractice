package com.practice.random;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by abhi.pandey on 3/15/16.
 */
public class SortEmployee {

    public static void main(String[] args) {
        Employee e1 = new Employee("Mr", "Abhishek", "Pandey");
        Employee e2 = new Employee("Mr", "Abhinav", "Pandey");
        Employee e3 = new Employee("Mr", "Manu", "Vyas");
        Employee e4 = new Employee("Mrs", "Tanvi", "Vyas");

        Employee[] employees = {e2, e4, e3, e1};
        new SortEmployee().sortEmployee(employees);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getfName());
        }

    }

    public void sortEmployee(Employee[] employees) {
        Arrays.sort(employees, new EmployeeComparator());
    }

    class EmployeeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee e1, Employee e2) {
            int t = e1.getlName().compareToIgnoreCase(e2.getlName());

            if (t == 0) {
                t = e1.getfName().compareToIgnoreCase(e2.getfName());

            }
            return t;
        }
    }

}
