package com.doskoch.fpm.web5.controller.listener;

import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;

import org.apache.logging.log4j.LogManager;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionListener;

import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_LOCALISATION;

@WebListener
public class SessionCreateListenerImpl implements HttpSessionListener {

    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_LOCALISATION = "en";

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute(ATTRIBUTE_LOCALISATION, DEFAULT_LOCALISATION);
        logger.info("session created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("session destroyed: " + se.getSession().getId());
    }
}
