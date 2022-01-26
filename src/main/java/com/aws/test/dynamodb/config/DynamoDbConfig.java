package com.aws.test.dynamodb.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfig {

    @Value("${accessKey}")
    private String accessKey;
    @Value("${secretKey}")
    private String secretKey;


    @Bean
    public DynamoDBMapper mapper() {
        return new DynamoDBMapper(buildAmazonDynamoDb());
    }

    private AmazonDynamoDB buildAmazonDynamoDb() {

        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        "dynamodb.us-west-2.amazonaws.com",
                        "us-west-2"
                )).withCredentials(

                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        accessKey, secretKey
                                )
                        )

                ).build();
    }
}