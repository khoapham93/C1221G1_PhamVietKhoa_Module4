package com.khoapham.service.impl;

import com.khoapham.model.Login;
import com.khoapham.model.User;
import com.khoapham.repository.IUserRepository;
import com.khoapham.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User checkLogin(Login login) {
        return this.iUserRepository.checkLogin(login);
    }
}
