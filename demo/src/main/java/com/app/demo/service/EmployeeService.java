package com.app.demo.service;

import com.app.demo.dao.EmployeeRepository;
import com.app.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable String id) {
        return employeeRepository.findById(id);
    }

}
