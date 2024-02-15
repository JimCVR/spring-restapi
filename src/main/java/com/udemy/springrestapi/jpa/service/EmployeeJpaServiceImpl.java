package com.udemy.springrestapi.jpa.service;

import com.udemy.springrestapi.entity.Employee;
import com.udemy.springrestapi.jpa.dao.EmployeeDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeJpaServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeJpaServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
