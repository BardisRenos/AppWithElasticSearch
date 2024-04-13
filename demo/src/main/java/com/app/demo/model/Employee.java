package com.app.demo.model;

import com.app.demo.indices.Indices;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@Document(indexName = Indices.EMPLOYEE_INDEX)
public class Employee {

    @Id
    private String id;
    @Field(type = FieldType.Text, name = "firstName")
    private String firstName;
    @Field(type = FieldType.Text, name = "lastName")
    private String lastName;
    @Field(type = FieldType.Text, name = "department")
    private String department;
}
