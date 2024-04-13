package com.app.demo.service;

import com.app.demo.dao.EmployeeRepository;
import com.app.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Service
public class EmployeeService {
    private final EmployeeRepository elasticSearchQuery;

    @Autowired
    public EmployeeService(EmployeeRepository elasticSearchQuery) {
        this.elasticSearchQuery = elasticSearchQuery;
    }

    public Employee findById(@PathVariable String id) throws IOException {
        return elasticSearchQuery.findDocById(id);
    }

    public String insertNewEmployee(Employee employee) throws IOException {
        return elasticSearchQuery.createOrUpdateDocument(employee);
    }
}
