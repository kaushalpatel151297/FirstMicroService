package com.firstmicroservice.departmentservice.Controller;

import com.firstmicroservice.departmentservice.Clinet.EmployeeClient;
import com.firstmicroservice.departmentservice.Model.department;
import com.firstmicroservice.departmentservice.Reposiotry.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deaprtment")
public class DepartmentController {

    @Autowired
    private DepartmentRepository deaprtmentRepo;

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private EmployeeClient employeeClient;


    @PostMapping("/create")
    public department AddDepartment(@RequestBody department departments) {
        LOGGER.info("Department add: {}", departments
        );
        return this.deaprtmentRepo.addDeaprtment(departments);
    }

    @GetMapping("/")
    public List<department> listDepartments() {
        LOGGER.info("Department find");
        return this.deaprtmentRepo.findAll();
    }

    @GetMapping("/{id}")
    public department GetDepartmentId(@PathVariable("id") Long id) {
        LOGGER.info("Department find: id={}", id);
        return this.deaprtmentRepo.findById(id);
    }

    @GetMapping("/with-employees")
    public List<department> findAllWithEmployees() {
        LOGGER.info("Department find");
        List<department> departments
                = deaprtmentRepo.findAll();
        departments.forEach(department ->
                department.setEmployees(
                        employeeClient.getEmployeebyDeaprtmentID(department.getId())));
        return departments;
    }
}
