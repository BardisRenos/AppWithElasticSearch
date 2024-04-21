package com.app.demo.controller;

import com.app.demo.model.Employee;
import com.app.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable String id) throws IOException {
        return employeeService.findById(id);
    }

    @PostMapping("/add")
    public String insertEmployee(@RequestBody Employee employee) throws IOException {
        return employeeService.insertNewEmployee(employee);
    }

}
