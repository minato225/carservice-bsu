package com.doskoch.fpm.web5.controller.command.common;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

import com.doskoch.fpm.web5.model.auth.User;
import com.doskoch.fpm.web5.model.auth.UserType;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.controller.navigation.Router;
import com.doskoch.fpm.web5.model.userservice.UserService;
import com.doskoch.fpm.web5.model.userservice.IUserService;
import com.doskoch.fpm.web5.util.locale.LocalisedMessageKey;
import com.doskoch.fpm.web5.model.dao.exceptions.DaoException;
import com.doskoch.fpm.web5.util.validator.LogInFormValidator;

import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.*;
import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.HOME;
import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.AUTHORISATION;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.REDIRECT;

public class LoginCommand implements ICommand {
    public static IUserService userService = new UserService();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        var session = request.getSession();

        var login = request.getParameter(PARAMETER_EMAIL);
        var password = request.getParameter(PARAMETER_PASSWORD);

        UserType type;
        if (Objects.equals(password, "admin") && Objects.equals(login, "admin@bsu.by"))
            type = UserType.ADMIN;
        else if (login.contains("driver"))
            type = UserType.CARDRIVER;
        else
            type = UserType.PASSENGER;

        var user = new User(login, password, type);

        var validationFeedback = LogInFormValidator.getInstance().validateForm(request.getParameterMap());

        var page = AUTHORISATION;
        var pageChangeType = FORWARD;

        if (!validationFeedback.isEmpty()) {
            request.setAttribute(REQUEST_ATTRIBUTE_FORM_INVALID, validationFeedback);
            return new Router(page, pageChangeType);
        }

        try {
            userService.AddNewUser(login, password, type);
            session.setAttribute(ATTRIBUTE_USER, user);
            page = HOME;
            pageChangeType = REDIRECT;
            session.setAttribute(ATTRIBUTE_CURRENT_PAGE, HOME);
        } catch (DaoException e) {
            request.setAttribute(REQUEST_ATTRIBUTE_USER_INVALID, LocalisedMessageKey.MESSAGE_USER_INVALID);
            throw new RuntimeException(e);
        }

        return new Router(page, pageChangeType);
    }
}
