package com.firstmicroservice.employeeservice.Model;

public record Employee(Long id, Long departmentId, String name, int age, String position) {
}
