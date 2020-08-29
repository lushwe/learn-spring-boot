package com.lushwe.learn.exception;

import com.alibaba.fastjson.JSON;
import com.lushwe.learn.entity.ApiRes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异常统一处理，方式一
 *
 * @author Jack Liu
 * @date 2018/9/1 21:43
 */
//@Component
public class ApiHandlerExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

        response.setCharacterEncoding("UTF-8");

        ApiRes entity = ExceptionUtils.buildApiResultEntity(e);

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(JSON.toJSONString(entity));
            writer.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return new ModelAndView();
    }
}
