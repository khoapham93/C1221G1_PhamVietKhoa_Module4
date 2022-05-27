package com.khoapham.service;

import com.khoapham.models.employee.Employee;
import com.khoapham.models.user.AppUser;

public interface IAppUserService {
    void registerNewUserAccount(Employee employee, AppUser appUser);
    public void remove(AppUser appUser);
}
