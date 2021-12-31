package com.lushwe.learn.dal;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO 写点注释吧
 *
 * @author liusw
 * @version V1.0
 * @since 12/31/21 2:06 PM
 */
@Configuration
public class FluentMybatisConfig {

    @Bean
    public MapperFactory mapperFactory() {
        return new MapperFactory();
    }
}
