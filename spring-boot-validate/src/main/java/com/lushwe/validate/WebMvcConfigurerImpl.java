package com.lushwe.validate;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 说明：WebMvcConfigurer实现类
 *
 * @author Jack Liu
 * @date 2021-06-24 20:48
 * @since 0.1
 */
@Component
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 将Json转换器添加到第一位，这样返回的字符串就可以处理了
        converters.add(0, new MappingJackson2HttpMessageConverter());
    }
}
