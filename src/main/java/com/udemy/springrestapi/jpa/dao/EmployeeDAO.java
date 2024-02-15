package com.udemy.springrestapi.jpa.dao;

import com.udemy.springrestapi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
}
