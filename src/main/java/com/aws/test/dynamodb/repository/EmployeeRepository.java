package com.aws.test.dynamodb.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.aws.test.dynamodb.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Employee save(Employee employee) {
        dynamoDBMapper.save(employee);

        return employee;
    }

    public Employee getEmployee(String empId) {
        return dynamoDBMapper.load(Employee.class, empId);
    }

    public String deleteEmployee(String empId) {
        Employee employee = dynamoDBMapper.load(Employee.class, empId);
        dynamoDBMapper.delete(employee);
        return "Employee Deleted";
    }

    public String updateEmployee(String empId, Employee employee) {
        dynamoDBMapper.save(employee,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("employeeId",
                                new ExpectedAttributeValue(new AttributeValue(
                                ).withS(empId))));
        return "Updated!!!";
    }
}
