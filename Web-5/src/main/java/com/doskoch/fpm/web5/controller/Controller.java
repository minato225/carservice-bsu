package com.doskoch.fpm.web5.controller;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.command.CommandType;

import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.PARAMETER_COMMAND;

@WebServlet(name = "AppController", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void init() {
        logger.info("Servlet init");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        var commandStr = request.getParameter(PARAMETER_COMMAND);
        var command = CommandType.defineCommand(commandStr);

        try {
            var router = command.execute(request);
            var page = router.getPage();

            switch (router.getType()) {
                case FORWARD -> request.getRequestDispatcher(page).forward(request, response);
                case REDIRECT -> response.sendRedirect(request.getContextPath() + page);
                default -> {
                    logger.error("Invalid routing type!");
                    response.sendError(500);
                }
            }

        } catch (CommandException e) {
            logger.error("Error while command execution: " + commandStr, e);
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
        logger.info("Servlet destroy");
    }
}
