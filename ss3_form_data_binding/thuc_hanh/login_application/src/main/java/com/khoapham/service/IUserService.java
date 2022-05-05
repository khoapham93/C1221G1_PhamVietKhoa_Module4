package com.khoapham.service;

import com.khoapham.model.Login;
import com.khoapham.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
