package com.firstmicroservice.employeeservice.Reposiotry;

import com.firstmicroservice.employeeservice.Model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeReposiotry {


    List<Employee> employeees  =  new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employeees.add(employee);
        return employee;
    }

    public Employee GetEmployee(Long id)
    {
        return employeees.stream().filter(aa -> aa.id() == id).findFirst().orElseThrow();
    }
    public List<Employee> listEmployee()
    {
        return employeees;
    }

    public List<Employee> getDepartments(Long departmentId)
    {
        return employeees.stream()
                .filter(bb->bb.departmentId() == departmentId).toList();
    }
}
