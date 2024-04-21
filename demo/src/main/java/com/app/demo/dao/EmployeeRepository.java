package com.app.demo.dao;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.app.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Map;


@Repository
public class EmployeeRepository {

    @Value("${elastic.index.name}")
    public String EMPLOYEE;

    private final ElasticsearchClient elasticsearchClient;

    @Autowired
    public EmployeeRepository(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }


    public String createOrUpdateDocument(Employee employee) throws IOException {
        IndexResponse response= elasticsearchClient.index(i->i.index(EMPLOYEE).id(employee.getId()).document(employee));

        Map<String,String> responseMessages = Map.of(
                "Created","Document has been created",
                "Updated", "Document has been updated"
        );

        return responseMessages.getOrDefault(response.result().name(),"Error has occurred");
    }

    public Employee findDocumentById(String productId) throws IOException {
        return elasticsearchClient.get(g -> g.index(EMPLOYEE).id(productId), Employee.class).source();
    }

    public Employee findDocumentByName(String name) throws IOException {
        return elasticsearchClient.get(g -> g.index(EMPLOYEE).id(name), Employee.class).source();
    }
}
