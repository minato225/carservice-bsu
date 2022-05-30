package com.doskoch.fpm.web5.controller.command.common;

import javax.servlet.http.HttpServletRequest;
import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.navigation.Router;

import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.DEFAULT;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_CURRENT_PAGE;

public class DefaultCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        request.getSession().setAttribute(ATTRIBUTE_CURRENT_PAGE, DEFAULT);

        return new Router(DEFAULT, FORWARD);
    }
}
