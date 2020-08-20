package com.lushwe.es;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 说明：StoreService
 *
 * @author Jack Liu
 * @date 2019-07-17 19:49
 * @since 1.0
 */
@Service
public class StoreService {

    @Resource
    private StoreRepository storeRepository;

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    public Store insert(Store store) {
        Store dbStore = storeRepository.index(store);
        return dbStore;
    }

    public Store update(Store store) {
        storeRepository.deleteById(store.getStoreCode());
        Store dbStore = storeRepository.index(store);
        return dbStore;
    }

    public void deleteById(String storeCode) {
        storeRepository.deleteById(storeCode);
    }


    public Store findById(String storeCode) {

        Optional<Store> optional = storeRepository.findById(storeCode);

        return optional.orElse(null);

    }

    public Page<Store> search() {

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.termQuery("cityCode", "0571"))
                .withPageable(PageRequest.of(1, 10, Sort.Direction.ASC, "updateTime"))
                .build();

        Page<Store> page = storeRepository.search(searchQuery);

        return page;
    }

    /**
     * 文本搜索
     *
     * @param text
     * @return
     */
    public List<Store> textSearch(String text) {

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery(text))
                .build();

        List<Store> storeList = elasticsearchTemplate.queryForList(searchQuery, Store.class);

        return storeList;
    }

    /**
     * 文本搜索
     *
     * @param text
     * @return
     */
    public Page<Store> textSearchForPage(String text) {

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery(text))
                .withPageable(PageRequest.of(1, 10, Sort.Direction.ASC, "updateTime"))
                .build();

        Page<Store> page = storeRepository.search(searchQuery);

        return page;
    }
}
