package com.app.demo.controller;

import com.app.demo.model.Employee;
import com.app.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
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
        log.info("The method to get an Employee by id");
        return employeeService.findById(id);
    }

    @PostMapping("/add")
    public String insertEmployee(@RequestBody Employee employee) throws IOException {
        log.info("The method to insert an Employee object");
        return employeeService.insertNewEmployee(employee);
    }

    @GetMapping("/getTest")
    public String getTest() {
        return "k8s success";
    }
}
