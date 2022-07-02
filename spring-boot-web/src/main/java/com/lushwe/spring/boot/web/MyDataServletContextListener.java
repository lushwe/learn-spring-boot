package com.lushwe.spring.boot.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2021-04-11 17:37
 * @since 0.1
 */
public class MyDataServletContextListener implements ServletContextListener {

    private ServletContext context = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();
        this.context.setAttribute("myData", "this is my data");
        System.out.println("MyDataServletContextListener initializer");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }
}
