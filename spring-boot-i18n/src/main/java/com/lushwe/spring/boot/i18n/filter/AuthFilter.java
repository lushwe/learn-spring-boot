package com.lushwe.spring.boot.i18n.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-08-24 15:36
 * @since 0.1
 */
@Slf4j
public class AuthFilter extends OncePerRequestFilter {

    private final MessageSource messageSource;

    public AuthFilter(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 请求头传值如：zh-CN，en-US，下面locale会自动转成如：zh_CN，en_US
        String acceptLanguage = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
        log.info("请求头语言 : {}", acceptLanguage);

        // 请求头不传，默认取计算机语言和地区，如：zh_CN，en_US
        Locale locale = LocaleContextHolder.getLocale();
        log.info("上下文语言 : {}", JSON.toJSONString(locale));

        String message = messageSource.getMessage("1", null, "", locale);
        log.info("多语言提示 : {}", message);

        filterChain.doFilter(request, response);
    }
}
