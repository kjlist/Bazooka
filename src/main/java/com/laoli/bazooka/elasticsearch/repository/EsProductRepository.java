package com.laoli.bazooka.elasticsearch.repository;


import com.laoli.bazooka.elasticsearch.domain.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface EsProductRepository extends ElasticsearchRepository<EsProduct, String> {
    /**
     * 搜索查询
     *
     * @param name              商品名称
     * @return
     */
    Page<EsProduct> findByName(String name,Pageable page);

}
