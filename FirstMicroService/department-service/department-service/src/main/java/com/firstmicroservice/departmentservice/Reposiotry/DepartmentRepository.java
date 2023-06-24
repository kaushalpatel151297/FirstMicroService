package com.firstmicroservice.departmentservice.Reposiotry;

import com.firstmicroservice.departmentservice.Model.department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DepartmentRepository{

    private List<department> departments  = new ArrayList<>();

    public department addDeaprtment(department department)
    {
        departments.add(department);
        return department;
    }
    public department findById(Long id)
    {
        department findbyIds = departments.stream().filter(deaprtment -> deaprtment.getId() == id).findFirst().orElseThrow();
        return findbyIds;
    }
    public List<department> findAll()
    {
        return departments;
    }
}
