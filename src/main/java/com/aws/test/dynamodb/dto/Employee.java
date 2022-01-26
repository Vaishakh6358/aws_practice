package com.aws.test.dynamodb.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "employee")
public class Employee {
    @DynamoDBAutoGeneratedKey
    @DynamoDBHashKey
    private String employeeId;
    @DynamoDBAttribute
    private String firstName;
    @DynamoDBAttribute
    private String lastName;
    @DynamoDBAttribute
    private String email;
    @DynamoDBAttribute
    private Department department;
}