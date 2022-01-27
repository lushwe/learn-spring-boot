package com.lushwe.learn.service;

import com.lushwe.learn.dto.UserDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * TODO 写点注释吧
 *
 * @author liusw
 * @version V1.0
 * @since 1/14/22 5:55 PM
 */
@Component
public class UserService {

    @Cacheable(cacheNames = "caffeine", cacheManager = "caffeineCacheManager", key = "#id")
    public UserDTO findById(Long id) {

        UserDTO userDTO = new UserDTO();

        userDTO.setId(1L);
        userDTO.setName("name" + System.currentTimeMillis());

        return userDTO;
    }

    @Cacheable(cacheNames = "redis2", cacheManager = "redisCacheManager", key = "#userDTO.id")
    public UserDTO findById(UserDTO userDTO) {

        UserDTO result = new UserDTO();

        result.setId(1L);
        result.setName("name" + System.currentTimeMillis());

        return result;
    }

    @Cacheable(cacheNames = "redis2", cacheManager = "redisCacheManager", key = "#userDTO.id")
    public UserDTO findNameById(UserDTO userDTO) {

        UserDTO result = new UserDTO();

        result.setId(1L);
        result.setName("name" + System.currentTimeMillis());

        return result;
    }
}
