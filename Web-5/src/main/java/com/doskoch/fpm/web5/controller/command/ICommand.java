package com.doskoch.fpm.web5.controller.command;

import javax.servlet.http.HttpServletRequest;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.navigation.Router;

public interface ICommand {
    Router execute(HttpServletRequest request) throws CommandException;
}
