package com.doskoch.fpm.web5.controller.listener;

import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;

import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Context init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Context destroy");
    }
}
