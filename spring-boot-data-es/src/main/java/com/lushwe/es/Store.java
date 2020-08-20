package com.lushwe.es;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 说明：实体类
 *
 * @author Jack Liu
 * @date 2019-07-17 19:21
 * @since 1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "store", type = "store")
public class Store {

    @Id
    private String storeCode;
    private String storeName;
    private String cityCode;
    private String address;
    private String owner;
    private String orgName;
    private String operatorName;
}
