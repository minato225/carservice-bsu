package com.doskoch.fpm.web5.model.userservice;

import com.doskoch.fpm.web5.model.auth.UserType;
import com.doskoch.fpm.web5.model.dao.exceptions.DaoException;

public interface IUserService {
    void AddNewUser(String email, String password, UserType type) throws DaoException;
}
