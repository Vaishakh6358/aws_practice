package com.aws.test.dynamodb.controller;

import com.aws.test.dynamodb.dto.Employee;
import com.aws.test.dynamodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping(value="/{empId}")
    public ResponseEntity<Employee> getEmployee (@PathVariable String empId)
    {
        return ResponseEntity.ok(employeeRepository.getEmployee(empId));
    }

    @DeleteMapping(value = "/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String empId)
    {
        return ResponseEntity.ok(employeeRepository.deleteEmployee(empId));
    }


}
