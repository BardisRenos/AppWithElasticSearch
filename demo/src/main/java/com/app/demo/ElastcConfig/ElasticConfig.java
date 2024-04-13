package com.app.demo.ElastcConfig;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.app.demo.dao")
//@ComponentScan(basePackages = {"com.app.demo"})
public class ElasticConfig {

    @Bean
    public RestClient getRestClient() {
        return RestClient.builder(
                new HttpHost("localhost", 9200)).setDefaultHeaders(new Header[]{
                        new BasicHeader("Content-type", "application/json")
        }).build();
    }

    @Bean
    public  ElasticsearchTransport getElasticsearchTransport() {
        return new RestClientTransport(
                getRestClient(), new JacksonJsonpMapper());
    }

}
