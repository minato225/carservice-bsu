package com.doskoch.fpm.web5.controller.command.update;

import com.doskoch.fpm.web5.model.dao.exceptions.DaoException;
import com.doskoch.fpm.web5.model.entity.Brand;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.model.carservice.ICarService;
import com.doskoch.fpm.web5.controller.navigation.Router;
import com.doskoch.fpm.web5.model.carservice.MySqlCarService;
import com.doskoch.fpm.web5.util.validator.AddProductFormValidator;

import javax.servlet.http.HttpServletRequest;

import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.REQUEST_ATTRIBUTE_FORM_INVALID;
import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.*;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_CURRENT_PAGE;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.REDIRECT;

public class AddCarCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        var session = request.getSession();

        var number = Integer.parseInt(request.getParameter("number"));
        var brand = Brand.valueOf(request.getParameter("brand"));
        var mileage = Integer.parseInt(request.getParameter("mileage"));
        var state = Integer.parseInt(request.getParameter("state"));

        var validator = AddProductFormValidator.getInstance();
        var requestParameters = request.getParameterMap();
        var validationFeedback = validator.validateForm(requestParameters);

        if(!validationFeedback.isEmpty()){
            request.setAttribute(REQUEST_ATTRIBUTE_FORM_INVALID, validationFeedback);
            return new Router(ADD_CAR, FORWARD);
        }

        ICarService dao = new MySqlCarService();
        try {
            dao.AddNewCar(number,brand, mileage, state);
            session.setAttribute(ATTRIBUTE_CURRENT_PAGE, CARS);
        } catch (NumberFormatException e) {
            throw new CommandException(e);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

        return new Router(CARS, REDIRECT);
    }
}
