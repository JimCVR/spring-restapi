package com.udemy.springrestapi.jpa.service;

import com.udemy.springrestapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
}
