package com.khoapham.service;

import com.khoapham.models.employee.Employee;
import com.khoapham.models.user.AppRole;
import com.khoapham.models.user.AppUser;
import com.khoapham.models.user.UserRole;

public interface IUserRoleService {
    void setUserRoleForNewUser(Employee employee,AppRole roleUser, AppRole roleAdmin,AppUser appUser);
}
