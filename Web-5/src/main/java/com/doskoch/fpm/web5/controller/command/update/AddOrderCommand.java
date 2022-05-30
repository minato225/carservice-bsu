package com.doskoch.fpm.web5.controller.command.update;

import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.controller.navigation.Router;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.model.carservice.ICarService;
import com.doskoch.fpm.web5.model.carservice.MySqlCarService;
import com.doskoch.fpm.web5.model.dao.exceptions.DaoException;
import com.doskoch.fpm.web5.model.entity.Brand;

import javax.servlet.http.HttpServletRequest;

import java.sql.Time;

import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.ORDERS;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.REDIRECT;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_CURRENT_PAGE;

public class AddOrderCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        var session = request.getSession();

        var brand = Brand.valueOf(request.getParameter("brand"));
        var mileage = Integer.parseInt(request.getParameter("mileage"));
        var isFinished = Boolean.parseBoolean(request.getParameter("is_finished"));
        var departure = request.getParameter("departure");
        var destination = request.getParameter("destination");
        var startTime = Time.valueOf(request.getParameter("start_time"));

        ICarService dao = new MySqlCarService();
        try {
            dao.AddNewOrder(brand, mileage, isFinished, departure, destination, startTime);
            session.setAttribute(ATTRIBUTE_CURRENT_PAGE, ORDERS);
        } catch (NumberFormatException e) {
            throw new CommandException(e);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

        return new Router(ORDERS, REDIRECT);
    }
}
