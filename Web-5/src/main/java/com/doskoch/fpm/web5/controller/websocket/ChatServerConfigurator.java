package com.doskoch.fpm.web5.controller.websocket;

import com.doskoch.fpm.web5.model.auth.User;
import com.doskoch.fpm.web5.model.auth.UserType;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_USER;

public class ChatServerConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        var session = (HttpSession) request.getHttpSession();
        var user = (User) session.getAttribute(ATTRIBUTE_USER);

        var username = user.type == UserType.ADMIN ? "Admin" : user.getEmail();

        sec.getUserProperties().put("username", username);
    }
}
