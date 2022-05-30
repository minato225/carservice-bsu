package com.doskoch.fpm.web5.controller.command.get;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.doskoch.fpm.web5.model.carservice.ICarService;
import com.doskoch.fpm.web5.model.carservice.MySqlCarService;
import com.doskoch.fpm.web5.model.entity.Cardriver;
import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.navigation.Router;

import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.DRIVERS;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_CURRENT_PAGE;

public class CarDriversCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        var session = request.getSession();
        session.setAttribute(ATTRIBUTE_CURRENT_PAGE, DRIVERS);

        List<Cardriver> drivers = null;
        ICarService dao = new MySqlCarService();
        try {
            drivers = dao.selectDrivers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("drivers", drivers);
        return new Router(DRIVERS, FORWARD);
    }
}
