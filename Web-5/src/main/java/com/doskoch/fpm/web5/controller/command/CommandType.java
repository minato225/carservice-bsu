package com.doskoch.fpm.web5.controller.command;

import com.doskoch.fpm.web5.controller.command.get.*;
import com.doskoch.fpm.web5.controller.command.common.LoginCommand;
import com.doskoch.fpm.web5.controller.command.update.AddCarCommand;
import com.doskoch.fpm.web5.controller.command.common.DefaultCommand;
import com.doskoch.fpm.web5.controller.command.common.ChangeLocalisationCommand;
import com.doskoch.fpm.web5.controller.command.update.AddOrderCommand;

public enum CommandType {
    DEFAULT(new DefaultCommand()),
    CHANGE_LOCALISATION(new ChangeLocalisationCommand()),
    LOGIN(new LoginCommand()),
    GET_ORDERS(new OrdersCommand()),
    GET_CARDRIVERS(new CarDriversCommand()),

    GET_CARS(new CarCommand()),
    GET_BROKEN(new BrokenCommand()),
    START_ADD_CAR(new RoutAddCarCommand()),
    START_ADD_ORDER(new RoutAddOrderCommand()),

    ADD_CAR(new AddCarCommand()),
    ADD_ORDER(new AddOrderCommand()),

    // Chat
    TO_CHAT(new ToChatCommand());

    private final ICommand command;

    CommandType(ICommand command) {
        this.command = command;
    }

    public static ICommand defineCommand(String commandStr) {

        if (commandStr == null) {
            return DEFAULT.command;
        }

        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandType = DEFAULT;
        }
        return commandType.command;
    }

    public static CommandType defineCommandType(String commandStr) {

        if (commandStr == null) {
            return DEFAULT;
        }

        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandType = DEFAULT;
        }
        return commandType;
    }
}
