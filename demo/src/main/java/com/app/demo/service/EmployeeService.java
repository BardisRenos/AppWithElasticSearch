package com.app.demo.service;

import com.app.demo.dao.EmployeeRepository;
import com.app.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

/**
 *
 */
@Service
public class EmployeeService {
    private final EmployeeRepository elasticSearchQuery;

    /**
     * The constructor
     * @param elasticSearchQuery EmployeeRepository class
     */
    @Autowired
    public EmployeeService(EmployeeRepository elasticSearchQuery) {
        this.elasticSearchQuery = elasticSearchQuery;
    }

    /**
     * The method finds Document by a given ID
     * @param id the ID
     * @return Employee class
     * @throws IOException Exception
     */
    public Employee findById(@PathVariable String id) throws IOException {
        return elasticSearchQuery.findDocumentById(id);
    }

    /**
     * The method inserts a new Document
     * @param employee Employee class
     * @return String type
     * @throws IOException Exception
     */
    public String insertNewEmployee(Employee employee) throws IOException {
        return elasticSearchQuery.createOrUpdateDocument(employee);
    }
}
