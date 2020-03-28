package com.laoli.bazooka.elasticsearch.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "test", type = "data")
public class Test {

    @Id
    private Long id;

    private String key;

    private String value;
}