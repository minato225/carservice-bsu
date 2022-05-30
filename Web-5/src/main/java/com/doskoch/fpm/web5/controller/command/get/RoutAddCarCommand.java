package com.doskoch.fpm.web5.controller.command.get;

import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.controller.navigation.Router;
import com.doskoch.fpm.web5.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_CURRENT_PAGE;
import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.ADD_CAR;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;

public class RoutAddCarCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        request.getSession().setAttribute(ATTRIBUTE_CURRENT_PAGE, ADD_CAR);
        return new Router(ADD_CAR, FORWARD);
    }
}
