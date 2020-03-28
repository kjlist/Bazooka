package com.laoli.bazooka.elasticsearch;

import com.laoli.bazooka.elasticsearch.domain.EsProduct;
import com.laoli.bazooka.elasticsearch.domain.EsProductRelatedInfo;
import com.laoli.bazooka.elasticsearch.domain.Post;
import com.laoli.bazooka.elasticsearch.domain.Test;
import com.laoli.bazooka.elasticsearch.repository.DespTestRepository;
import com.laoli.bazooka.elasticsearch.repository.EsProductRepository;
import com.laoli.bazooka.elasticsearch.repository.PostRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.bucket.filter.InternalFilter;
import org.elasticsearch.search.aggregations.bucket.nested.InternalNested;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.*;

@RestController
@Slf4j
public class EsTestController {

    @Autowired
    private EsProductRepository productRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;



//    @Autowired
//    private DespTestRepository despTestRepository;

    @RequestMapping("/esInit")
    public void esInit() {
        List<EsProduct> esProductList = new ArrayList<>();
        EsProduct esProduct1 = new EsProduct();
        esProduct1.setBrandId(1L);
        esProduct1.setBrandName("小米电饭煲");
        esProduct1.setPic("pic1.img");
        esProduct1.setName("小米电饭煲 1L");

        EsProduct esProduct2 = new EsProduct();
        esProduct2.setBrandId(2L);
        esProduct2.setBrandName("小米电视机");
        esProduct2.setPic("pic2.img");
        esProduct2.setName("小米电视机 32英寸");


        EsProduct esProduct3 = new EsProduct();
        esProduct3.setBrandId(3L);
        esProduct3.setBrandName("小米手机");
        esProduct3.setPic("pic3.img");
        esProduct3.setName("小米手机 32GB");

        EsProduct esProduct4 = new EsProduct();
        esProduct4.setBrandId(4L);
        esProduct4.setBrandName("小米手机");
        esProduct4.setPic("pic4.img");
        esProduct4.setName("小米手机 64GB");


        EsProduct esProduct5 = new EsProduct();
        esProduct5.setBrandId(5L);
        esProduct5.setBrandName("苹果手机");
        esProduct5.setPic("pic5.img");
        esProduct5.setName("苹果手机 64GB");

        esProductList.add(esProduct1);
        esProductList.add(esProduct2);
        esProductList.add(esProduct3);
        esProductList.add(esProduct4);
        esProductList.add(esProduct5);



        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        while (iterator.hasNext()) {
            log.info("esInit---EsProduct:[{}]",iterator.next());
        }

    }




    //普通搜索
    @RequestMapping("/search")
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByName(keyword,pageable);
    }




//    @Autowired
//    private PostRepository postRepository;

    private List<String> getTitle() {
        List<String> list = new ArrayList<>();
        list.add("《如梦令·常记溪亭日暮》");
        list.add("《醉花阴·薄雾浓云愁永昼》");
        list.add("《声声慢·寻寻觅觅》");
        list.add("《永遇乐·落日熔金》");
        list.add("《如梦令·昨夜雨疏风骤》");
        list.add("《渔家傲·雪里已知春信至》");
        list.add("《点绛唇·蹴[1]罢秋千》");
        list.add("《点绛唇·寂寞深闺》");
        list.add("《蝶恋花·泪湿罗衣脂粉满》");
        list.add("《蝶恋花 离情》");
        list.add("《浣溪沙》");
        list.add("《浣溪沙》");
        list.add("《浣溪沙》");
        list.add("《浣溪沙》");
        list.add("《浣溪沙》");
        list.add("《减字木兰花·卖花担上》");
        list.add("《临江仙·欧阳公作《蝶恋花》");
        list.add("《临江仙·庭院深深深几许》");
        list.add("《念奴娇·萧条庭院》");
        list.add("《菩萨蛮·风柔日薄春犹早》");
        list.add("《菩萨蛮·归鸿声断残云碧》");
        list.add("《武陵春·风住尘香花已尽》");
        list.add("《一剪梅·红藕香残玉蕈秋》");
        list.add("《渔家傲·天接云涛连晓雾》");
        list.add("《鹧鸪天·暗淡轻黄体性柔》");
        list.add("《鹧鸪天·寒日萧萧上锁窗》");
        list.add("《一剪梅·红藕香残玉簟秋》");
        list.add("《如梦令·常记溪亭日暮》");
        list.add("《浣溪沙》");
        list.add("《浣溪沙》");
        list.add("《浣溪沙》");
        list.add("《蝶恋花·泪湿罗衣脂粉满》");
        list.add("《蝶恋花·暖日晴风初破冻》");
        list.add("《鹧鸪天·寒日萧萧上锁窗》");
        list.add("《醉花阴·薄雾浓云愁永昼》");
        list.add("《鹧鸪天·暗淡轻黄体性柔》");
        list.add("《蝶恋花·永夜恹恹欢意少》");
        list.add("《浣溪沙》");
        list.add("《浣溪沙》");
        list.add("《如梦令·谁伴明窗独坐》");
        return list;
    }

    private List<String> getContent() {
        List<String> list = new ArrayList<>();
        list.add("初中 宋·李清照 常记溪亭日暮，沉醉不知归路，兴尽晚回舟，误入藕花深处。争渡，争渡");
        list.add("重阳节 宋·李清照 薄雾浓云愁永昼，瑞脑消金兽。佳节又重阳，玉枕纱厨，半夜凉初透。东");
        list.add("闺怨诗 宋·李清照 寻寻觅觅，冷冷清清，凄凄惨惨戚戚。乍暖还寒时候，最难将息。三杯两");
        list.add("元宵节 宋·李清照 落日熔金，暮云合璧，人在何处。染柳烟浓，吹梅笛怨，春意知几许。元");
        list.add("婉约诗 宋·李清照 昨夜雨疏风骤，浓睡不消残酒，试问卷帘人，却道海棠依旧。知否，知否");
        list.add("描写梅花 宋·李清照 雪里已知春信至，寒梅点缀琼枝腻，香脸半开娇旖旎，当庭际，玉人浴出");
        list.add(" 宋·李清照 蹴罢秋千，起来慵整纤纤手。露浓花瘦，薄汗轻衣透。见客入来，袜刬金");
        list.add("闺怨诗 宋·李清照 寂寞深闺，柔肠一寸愁千缕。惜春春去。几点催花雨。倚遍阑干，只是无");
        list.add("婉约诗 宋·李清照 泪湿罗衣脂粉满。四叠阳关，唱到千千遍。人道山长水又断。萧萧微雨闻");
        list.add("描写春天 宋·李清照 暖雨晴风初破冻，柳眼梅腮，已觉春心动。酒意诗情谁与共？泪融残粉花");
        list.add("寒食节 宋·李清照 淡荡春光寒食天，玉炉沈水袅残烟，梦回山枕隐花钿。海燕未来人斗草，");
        list.add(" 宋·李清照 髻子伤春慵更梳，晚风庭院落梅初，淡云来往月疏疏，玉鸭薰炉闲瑞脑，");
        list.add(" 宋·李清照 莫许杯深琥珀浓，未成沉醉意先融。疏钟已应晚来风。瑞脑香消魂梦断，");
        list.add("闺怨诗 宋·李清照 小院闲窗春已深，重帘未卷影沉沉。倚楼无语理瑶琴，远岫出山催薄暮。");
        list.add("爱情诗 宋·李清照 绣幕芙蓉一笑开，斜偎宝鸭亲香腮，眼波才动被人猜。一面风情深有韵，");
        list.add("描写春天 宋·李清照 卖花担上，买得一枝春欲放。泪染轻匀，犹带彤霞晓露痕。怕郎猜道，奴");
        list.add("》 宋·李清照 欧阳公作《蝶恋花》，有“深深深几许”之句，予酷爱之。用其语作“庭");
        list.add("描写梅花 宋·李清照 庭院深深深几许，云窗雾阁春迟，为谁憔悴损芳姿。夜来清梦好，应是发");
        list.add("寒食节 宋·李清照 萧条庭院，又斜风细雨，重门须闭。宠柳娇花寒食近，种种恼人天气。险");
        list.add("思乡诗 宋·李清照 风柔日薄春犹早，夹衫乍著心情好。睡起觉微寒，梅花鬓上残。故乡何处");
        list.add("描写春天 宋·李清照 归鸿声断残云碧，背窗雪落炉烟直。烛底凤钗明，钗头人胜轻。角声催晓");
        list.add("闺怨诗 宋·李清照 风住尘香花已尽，日晚倦梳头。物是人非事事休，欲语泪先流。闻说双溪");
        list.add(" 宋·李清照 红藕香残玉蕈秋，轻解罗裳，独上兰舟。云中谁寄锦书来？雁字回时，月");
        list.add("豪放诗 宋·李清照 天接云涛连晓雾。星河欲转千帆舞。仿佛梦魂归帝所。闻天语。殷勤问我");
        list.add("描写花 宋·李清照 暗淡轻黄体性柔。情疏迹远只香留。何须浅碧深红色，自是花中第一流。");
        list.add("描写秋天 宋·李清照 寒日萧萧上琐窗，梧桐应恨夜来霜。酒阑更喜团茶苦，梦断偏宜瑞脑香。");
        list.add("闺怨诗 宋·李清照 红藕香残玉簟秋。轻解罗裳，独上兰舟。云中谁寄锦书来？雁字回时，月");
        list.add(" 宋·李清照 常记溪亭日暮。沈醉不知归路。兴尽晚回舟，误入藕花深处。争渡。争渡");
        list.add(" 宋·李清照 莫许杯深琥珀浓。未成沈醉意先融。已应晚来风。瑞脑香消魂梦断，");
        list.add(" 宋·李清照 小院闲窗春色深。重帘未卷影沈沈。倚楼无语理瑶琴。远岫出山催薄暮，");
        list.add(" 宋·李清照 淡荡春光寒食天。玉炉沈水袅残烟。梦回山枕隐花钿。海燕未来人斗草，");
        list.add(" 宋·李清照 泪湿罗衣脂粉满。四叠阳关，唱到千千遍。人道山长山又断。萧萧微雨闻");
        list.add(" 宋·李清照 暖日晴风初破冻。柳眼眉腮，已觉春心动。酒意诗情谁与共。泪融残粉花");
        list.add(" 宋·李清照 寒日萧萧上锁窗。梧桐应恨夜来霜。酒阑更喜团茶苦，梦断偏宜瑞脑香。");
        list.add(" 宋·李清照 薄雾浓云愁永昼。瑞脑消金兽。佳节又重阳，玉枕纱厨，半夜凉初透。东");
        list.add(" 宋·李清照 暗淡轻黄体性柔。情疏迹远只香留。何须浅碧深红色，自是花中第一流。");
        list.add(" 宋·李清照 永夜恹恹欢意少。空梦长安，认取长安道。为报今年春色好。花光月影宜");
        list.add(" 宋·李清照 髻子伤春慵更梳。晚风庭院落梅初。淡云来往月疏疏。玉鸭熏炉闲瑞脑，");
        list.add(" 宋·李清照 绣面芙蓉一笑开。斜飞宝鸭衬香腮。眼波才动被人猜。一面风情深有韵，");
        list.add(" 宋·李清照 谁伴明窗独坐，我共影儿俩个。灯尽欲眠时，影也把人抛躲。无那，无那");
        return list;
    }


//    @RequestMapping("/initPoem")
//    public void initPoem() {
//        Iterable<Post> posts = postRepository.findAll();
//        if (posts.iterator().hasNext()) {
//            return;
//        }
//        for (int i = 0; i < 40; i++) {
//            Post post = new Post();
//            post.setTitle(getTitle().get(i));
//            post.setContent(getContent().get(i));
//            post.setWeight(i);
//            post.setUserId(i % 10);
//            postRepository.save(post);
//        }
//    }
//
//
//    /**
//     * 单字符串模糊查询，默认排序。将从所有字段中查找包含传来的word分词后字符串的数据集
//     */
//    @RequestMapping("/singleWord")
//    public Object singleTitle(String word, @PageableDefault(sort = "weight", direction = Sort.Direction.DESC) Pageable pageable) {
//        //使用queryStringQuery完成单字符串查询
////        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(word)).withPageable(pageable).build();
////content匹配
////        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("content", word)).withPageable(pageable).build();
//
//        //不对传来的值分词，去找完全匹配的
////        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("content", word)).withPageable(pageable).build();
//
////        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(multiMatchQuery(word, "title", "content")).withPageable(pageable).build();
////        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("title", word).operator(MatchQueryBuilder.DEFAULT_OPERATOR)).build();
//
////        boolQuery，可以设置多个条件的查询方式。它的作用是用来组合多个 Query，有四种方式来组合，must，mustnot，filter，should。
////        must 代表返回的文档必须满足 must 子句的条件，会参与计算分值；
////        filter 代表返回的文档必须满足 filter 子句的条件，但不会参与计算分值；
////        should 代表返回的文档可能满足 should 子句的条件，也可能不满足，有多个 should 时满足任何一个就可以，通过 minimum_should_match 设置至少满足几个。
////        mustnot 代表必须不满足子句的条件。
//        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(boolQuery().must(termQuery("userId", word))
//                .should(rangeQuery("weight").lt(word)).must(matchQuery("title", word))).build();
//
//        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
//    }

    //recommend


    //获取搜索的相关品牌、分类及筛选属性
//    @RequestMapping("/searchRelatedInfo")
//    public EsProductRelatedInfo searchRelatedInfo(String keyword) {
//        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
//        //搜索条件
//        if(StringUtils.isEmpty(keyword)){
//            builder.withQuery(QueryBuilders.matchAllQuery());
//        }else{
//            builder.withQuery(QueryBuilders.multiMatchQuery(keyword,"name","subTitle","keywords"));
//        }
//        //聚合搜索品牌名称
//        builder.addAggregation(AggregationBuilders.terms("brandNames").field("brandName"));
//        //集合搜索分类名称
//        builder.addAggregation(AggregationBuilders.terms("productCategoryNames").field("productCategoryName"));
//        //聚合搜索商品属性，去除type=1的属性
//        AbstractAggregationBuilder aggregationBuilder = AggregationBuilders.nested("allAttrValues","attrValueList")
//                .subAggregation(AggregationBuilders.filter("productAttrs",QueryBuilders.termQuery("attrValueList.type",1))
//                        .subAggregation(AggregationBuilders.terms("attrIds")
//                                .field("attrValueList.productAttributeId")
//                                .subAggregation(AggregationBuilders.terms("attrValues")
//                                        .field("attrValueList.value"))
//                                .subAggregation(AggregationBuilders.terms("attrNames")
//                                        .field("attrValueList.name"))));
//        builder.addAggregation(aggregationBuilder);
//        NativeSearchQuery searchQuery = builder.build();
//        return elasticsearchTemplate.query(searchQuery, response -> {
//            log.info("DSL:{}",searchQuery.getQuery().toString());
//            return convertProductRelatedInfo(response);
//        });
//    }
    /**
     * 将返回结果转换为对象
     */
    private EsProductRelatedInfo convertProductRelatedInfo(SearchResponse response) {
        EsProductRelatedInfo productRelatedInfo = new EsProductRelatedInfo();
        Map<String, Aggregation> aggregationMap = response.getAggregations().getAsMap();
        //设置品牌
        Aggregation brandNames = aggregationMap.get("brandNames");
        List<String> brandNameList = new ArrayList<>();
        for(int i = 0; i<((Terms) brandNames).getBuckets().size(); i++){
            brandNameList.add(((Terms) brandNames).getBuckets().get(i).getKeyAsString());
        }
        productRelatedInfo.setBrandNames(brandNameList);
        //设置分类
        Aggregation productCategoryNames = aggregationMap.get("productCategoryNames");
        List<String> productCategoryNameList = new ArrayList<>();
        for(int i=0;i<((Terms) productCategoryNames).getBuckets().size();i++){
            productCategoryNameList.add(((Terms) productCategoryNames).getBuckets().get(i).getKeyAsString());
        }
        productRelatedInfo.setProductCategoryNames(productCategoryNameList);
        //设置参数
        Aggregation productAttrs = aggregationMap.get("allAttrValues");
        List<LongTerms.Bucket> attrIds = ((LongTerms) ((InternalFilter) ((InternalNested) productAttrs).getProperty("productAttrs")).getProperty("attrIds")).getBuckets();
        List<EsProductRelatedInfo.ProductAttr> attrList = new ArrayList<>();
        for (Terms.Bucket attrId : attrIds) {
            EsProductRelatedInfo.ProductAttr attr = new EsProductRelatedInfo.ProductAttr();
            attr.setAttrId((Long) attrId.getKey());
            List<String> attrValueList = new ArrayList<>();
            List<StringTerms.Bucket> attrValues = ((StringTerms) attrId.getAggregations().get("attrValues")).getBuckets();
            List<StringTerms.Bucket> attrNames = ((StringTerms) attrId.getAggregations().get("attrNames")).getBuckets();
            for (Terms.Bucket attrValue : attrValues) {
                attrValueList.add(attrValue.getKeyAsString());
            }
            attr.setAttrValues(attrValueList);
            if(!CollectionUtils.isEmpty(attrNames)){
                String attrName = attrNames.get(0).getKeyAsString();
                attr.setAttrName(attrName);
            }
            attrList.add(attr);
        }
        productRelatedInfo.setProductAttrs(attrList);
        return productRelatedInfo;
    }
}
