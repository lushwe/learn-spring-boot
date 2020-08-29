# Spring Boot 优雅处理异常

> Spring Boot 优雅处理异常

- 方法一：实现 `HandlerExceptionResolver`
- 方法二：继承 `ResponseEntityExceptionHandler` , 配合注解 `@ControllerAdvice` 和 `@ExceptionHandler`
- 推荐方法二