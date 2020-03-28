package com.laoli.bazooka.elasticsearch.repository;


import com.laoli.bazooka.elasticsearch.domain.Test;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DespTestRepository extends ElasticsearchRepository<Test, Long> {

    List<Test> findByKey(String key);
}