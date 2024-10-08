package com.tan.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestHighLevelClientConfig {

    @Bean
    public RestHighLevelClient getRestHighLevelClient(){
        return new RestHighLevelClient(RestClient.builder(HttpHost.create("192.168.2.140:9200")));
    }

}
