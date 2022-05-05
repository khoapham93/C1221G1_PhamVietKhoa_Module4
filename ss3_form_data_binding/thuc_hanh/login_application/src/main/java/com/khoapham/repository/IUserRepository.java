package com.khoapham.repository;

import com.khoapham.model.Login;
import com.khoapham.model.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
