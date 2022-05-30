package com.doskoch.fpm.web5.controller.command.get;

import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.controller.navigation.Router;

import javax.servlet.http.HttpServletRequest;

import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.ADD_ORDER;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_CURRENT_PAGE;

public class RoutAddOrderCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        request.getSession().setAttribute(ATTRIBUTE_CURRENT_PAGE, ADD_ORDER);
        return new Router(ADD_ORDER, FORWARD);
    }
}
