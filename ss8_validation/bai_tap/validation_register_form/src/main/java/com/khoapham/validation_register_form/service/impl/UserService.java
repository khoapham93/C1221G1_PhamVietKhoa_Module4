package com.khoapham.validation_register_form.service.impl;

import com.khoapham.validation_register_form.model.User;
import com.khoapham.validation_register_form.repository.IUserRepository;
import com.khoapham.validation_register_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        this.iUserRepository.save(user);
    }
}
