package com.lushwe.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 说明：数据仓储
 *
 * @author Jack Liu
 * @date 2019-07-17 19:03
 * @since 1.0
 */
@Repository
public interface StoreRepository extends ElasticsearchRepository<Store, String> {
}
