package com.firstmicroservice.employeeservice.Controller;

import com.firstmicroservice.employeeservice.Model.Employee;
import com.firstmicroservice.employeeservice.Reposiotry.EmployeeReposiotry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeReposiotry empoyeeRepo;

    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeController.class);


    @PostMapping("/create")
    public Employee createEmploy(@RequestBody Employee employee)
    {
        LOGGER.info("Employee find");
        return this.empoyeeRepo.addEmployee(employee);
    }
    @GetMapping("/ListEmployees")
    public List<Employee> listEmployees()
    {
        return this.empoyeeRepo.listEmployee();
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id)
    {
        return this.empoyeeRepo.GetEmployee(id);

    }
    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeebyDeaprtmentID(@PathVariable("departmentId") Long departmentId)
    {
        return this.empoyeeRepo.getDepartments(departmentId);
    }


}
