## spring-boot-aop

#### Sping AOP 实现数据查询缓存切面
- 缓存数据注解 `com.lushwe.spring.boot.aop.annotation.CacheData`
- 缓存数据切面 `com.lushwe.spring.boot.aop.aspect.CacheDataAspect`
- 缓存数据切面配置 `com.lushwe.spring.boot.aop.config.CacheDataAspectConfig`

#### Sping AOP 实现记录操作日志切面
- 记录操作日志注解 `com.lushwe.spring.boot.aop.annotation.OperationLog`
- 记录操作日志切面 `com.lushwe.spring.boot.aop.aspect.OperationLogAspect`
- 记录操作日志切面配置 `com.lushwe.spring.boot.aop.config.OperationLogAspectConfig`
- 参考项目 [spring-aspect](https://github.com/lushwe/learn-spring/tree/master/spring-aspect)

> 注意：项目中同时使用 `OperationLogAspect` 和 `CacheDataAspect` 时，`OperationLogAspect` 的顺序要在 `CacheDataAspect` 前面，否则当命中缓存时，不会进入操作日志的切面逻辑，导致记录操作日志失败