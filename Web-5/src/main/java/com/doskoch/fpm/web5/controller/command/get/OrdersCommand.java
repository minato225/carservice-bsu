package com.doskoch.fpm.web5.controller.command.get;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.doskoch.fpm.web5.model.carservice.ICarService;
import com.doskoch.fpm.web5.model.carservice.MySqlCarService;
import com.doskoch.fpm.web5.model.entity.Carorder;
import com.doskoch.fpm.web5.controller.command.ICommand;
import com.doskoch.fpm.web5.exception.CommandException;
import com.doskoch.fpm.web5.controller.navigation.Router;

import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.ORDERS;
import static com.doskoch.fpm.web5.controller.navigation.Router.PageChangeType.FORWARD;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.ATTRIBUTE_CURRENT_PAGE;


public class OrdersCommand implements ICommand {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        var session = request.getSession();
        session.setAttribute(ATTRIBUTE_CURRENT_PAGE, ORDERS);

        List<Carorder> orders = null;
        ICarService dao = new MySqlCarService();
        try {
            orders = dao.selectAllOrderTraces();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("orders", orders);
        return new Router(ORDERS, FORWARD);
    }
}
