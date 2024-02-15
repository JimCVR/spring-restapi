package com.udemy.springrestapi.jpa.controller;

import com.udemy.springrestapi.entity.Employee;
import com.udemy.springrestapi.jpa.service.EmployeeService;
import com.udemy.springrestapi.util.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jpa")
public class EmployeeJpaRestController {

    private EmployeeService employeeService;

    public EmployeeJpaRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        var employee = employeeService.findById(id);
        if (employee == null)
            throw new EntityNotFoundException("Employee not found for id: " + id);
        return employee;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> delete(@PathVariable int id){
        var employee = employeeService.findById(id);
        employeeService.delete(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}