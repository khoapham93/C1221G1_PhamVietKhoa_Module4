package com.khoapham.service;

import com.khoapham.dto.AppUserDto;
import com.khoapham.exception.UserAlreadyExists;
import com.khoapham.model.AppUser;
import org.springframework.validation.BindingResult;

public interface IAppUserService {
    void registerNewUserAccount(AppUser appUser);
    void userNameExists(AppUserDto appUserDto, BindingResult bindingResult);
}
