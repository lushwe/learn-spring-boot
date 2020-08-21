# spring-boot 跨域解决方案

> Spring Boot 解决跨域 demo

- 方法一
    - 全局生效
    - 实现接口 `WebMvcConfigurer` ，重写 `addCorsMappings` 方法

- 方法二
    - 局部生效
    - 使用注解 `@CrossOrigin`