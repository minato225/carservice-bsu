package com.doskoch.fpm.web5.controller.command.get;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.doskoch.fpm.web5.model.entity.Car;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.model.carservice.ICarService;
import com.doskoch.fpm.web5.controller.navigation.Router;
import com.doskoch.fpm.web5.model.carservice.MySqlCarService;

import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.CARS;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_CURRENT_PAGE;

public class CarCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        var session = request.getSession();
        session.setAttribute(ATTRIBUTE_CURRENT_PAGE, CARS);

        List<Car> cars = null;
        ICarService dao = new MySqlCarService();
        try {
            cars = dao.selectCars();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("cars", cars);

        return new Router(CARS, FORWARD);
    }
}
