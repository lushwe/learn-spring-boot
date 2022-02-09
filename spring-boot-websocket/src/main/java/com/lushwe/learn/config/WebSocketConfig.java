package com.lushwe.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * TODO 写点注释吧
 *
 * @author liusw
 * @version V1.0
 * @since 2/8/22 11:22 AM
 */
@Configuration
public class WebSocketConfig {


    @Bean
    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();
    }
}
