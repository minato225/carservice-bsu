package com.doskoch.fpm.web5.controller.command.common;

import javax.servlet.http.HttpServletRequest;
import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.navigation.Router;

import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.*;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;

public class ChangeLocalisationCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        var session = request.getSession();

        var localisation = request.getParameter(PARAMETER_LOCALISATION);
        session.setAttribute(ATTRIBUTE_LOCALISATION, localisation);

        var page = (String) session.getAttribute(ATTRIBUTE_CURRENT_PAGE);

        return new Router(page, FORWARD);
    }
}
