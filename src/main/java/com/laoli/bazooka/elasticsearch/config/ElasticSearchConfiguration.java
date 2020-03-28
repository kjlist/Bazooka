package com.laoli.bazooka.elasticsearch.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ElasticSearchConfiguration {

//    @Value("${elasticsearch.host}")
//    private String ES_HOST;
//
//    @Value("${elasticsearch.port}")
//    private Integer ES_PORT;
//
//    @Value("${elasticsearch.scheme}")
//    private String ES_SCHEME;
//
//    @Value("${elasticsearch.username}")
//    private String ES_USERNAME;
//
//    @Value("${elasticsearch.password}")
//    private String ES_PASSWORD;
//
//    @Bean
//    public RestHighLevelClient elasticsearchClient() {
//        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(ES_USERNAME, ES_PASSWORD));
//
//        RestClientBuilder builder = RestClient.builder(new HttpHost(ES_HOST, ES_PORT, ES_SCHEME))
//                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
//                        .setDefaultRequestConfig(RequestConfig.custom().setConnectTimeout(2000).setSocketTimeout(10000).setConnectionRequestTimeout(1000).build())
//                        .setMaxConnPerRoute(100).setMaxConnTotal(100));
//
//        return new RestHighLevelClient(builder);
//    }
//
//    @Bean
//    public ElasticsearchRestTemplate elasticsearchTemplate() {
//        return new ElasticsearchRestTemplate(elasticsearchClient());
//    }

}