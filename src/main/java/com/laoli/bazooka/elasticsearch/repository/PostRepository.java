package com.laoli.bazooka.elasticsearch.repository;


import com.laoli.bazooka.elasticsearch.domain.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface PostRepository extends ElasticsearchRepository<Post, String> {

}
