package com.doskoch.fpm.web5.model.userservice;

import com.doskoch.fpm.web5.model.auth.UserType;
import com.doskoch.fpm.web5.model.dao.DaoUser;
import com.doskoch.fpm.web5.model.dao.exceptions.DaoException;
import com.doskoch.fpm.web5.model.entity.User;

public class UserService implements IUserService {
    private final DaoUser daoUser = new DaoUser();

    @Override
    public void AddNewUser(String email, String password, UserType type) throws DaoException {
        var user = new User(email, password, type.ordinal() + 1);
        daoUser.save(user);
    }
}
