package com.laoli.bazooka.elasticsearch.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="projectname",type="post",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
@Data
public class Post {

    @Id
    private String id;

    private String title;

    private String content;

    private int userId;

    private int weight;

}
