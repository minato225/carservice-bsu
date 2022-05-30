package com.doskoch.fpm.web5.controller.filter;

import com.doskoch.fpm.web5.model.auth.User;
import com.doskoch.fpm.web5.model.auth.UserType;
import com.doskoch.fpm.web5.controller.command.CommandType;
import com.doskoch.fpm.web5.controller.navigation.PageNavigation;

import javax.servlet.*;
import java.util.EnumSet;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.doskoch.fpm.web5.controller.command.CommandType.*;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_USER;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.PARAMETER_COMMAND;

@WebFilter(filterName = "CheckUserStatusFilter", urlPatterns = {"/controller"})
public class CheckUserStatusFilter implements Filter {

    private EnumSet<CommandType> adminCommands, driverCommands, passengerCommands;

    @Override
    public void init(FilterConfig filterConfig) {
        adminCommands = EnumSet.of(
                DEFAULT, CHANGE_LOCALISATION, GET_CARDRIVERS, GET_BROKEN, GET_ORDERS,
                START_ADD_CAR, START_ADD_ORDER, ADD_CAR ,GET_CARS, TO_CHAT
        );
        driverCommands = EnumSet.of(DEFAULT, CHANGE_LOCALISATION, GET_CARDRIVERS, TO_CHAT);
        passengerCommands = EnumSet.of(DEFAULT, CHANGE_LOCALISATION, GET_ORDERS, LOGIN);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var request = (HttpServletRequest) servletRequest;
        var session = (HttpSession) request.getSession();
        var response = (HttpServletResponse) servletResponse;

        var commandStr = request.getParameter(PARAMETER_COMMAND);
        var command = CommandType.defineCommandType(commandStr);

        var user = (User) session.getAttribute(ATTRIBUTE_USER);
        var userStatus = user != null ? user.type : UserType.PASSENGER;

        EnumSet<CommandType> allowedCommands = null;
        switch (userStatus) {
            case ADMIN -> allowedCommands = adminCommands;
            case CARDRIVER -> allowedCommands = driverCommands;
            case PASSENGER -> allowedCommands = passengerCommands;
            default -> response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        if (!allowedCommands.contains(command)) {
            response.sendRedirect(request.getContextPath() + PageNavigation.AUTHORISATION);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
