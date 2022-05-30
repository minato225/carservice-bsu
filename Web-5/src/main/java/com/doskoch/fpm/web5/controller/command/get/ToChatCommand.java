package com.doskoch.fpm.web5.controller.command.get;

import javax.servlet.http.HttpServletRequest;
import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.navigation.Router;

import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.CHAT;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_CURRENT_PAGE;

public class ToChatCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        request.getSession().setAttribute(ATTRIBUTE_CURRENT_PAGE, CHAT);
        return new Router(CHAT, FORWARD);
    }
}
