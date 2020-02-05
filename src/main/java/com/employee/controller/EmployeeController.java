package com.employee.controller;

import com.employee.exception.ValidationException;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public String getEmployeeName(@PathVariable(value = "id") int employeeId) {
        if (employeeId <= 0) throw new ValidationException("id is equal to or less than zero");

        return employeeService.getEmployeeName();
    }
}
