package com.doskoch.fpm.web5.controller.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Set;
import java.util.HashSet;
import java.io.IOException;
import java.util.Collections;

@ServerEndpoint(value = "/controller/chatServerEndpoint", configurator = ChatServerConfigurator.class)
public class ChatServerEndpoint {

    private static final Logger logger = LogManager.getLogger();
    private static final Set<Session> chatUsers = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void handleOpen(EndpointConfig endpointConfig, Session userSession) {
        chatUsers.add(userSession);
    }

    @OnClose
    public void handleClose(Session userSession) {
        chatUsers.remove(userSession);
    }

    @OnError
    public void handleError(Throwable throwable) {
        logger.error(throwable);
    }

    @OnMessage
    public void handleMessage(String message, Session userSession) {
        var username = (String) userSession.getUserProperties().get("username");
        if (username == null) return;

        chatUsers.forEach(user -> {
            try {
                user.getBasicRemote().sendText(username + ": " + message);
            } catch (IOException e) {
                logger.error(e);
            }
        });
    }
}
