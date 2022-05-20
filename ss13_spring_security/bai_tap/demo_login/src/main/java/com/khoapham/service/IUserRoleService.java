package com.khoapham.service;

import com.khoapham.model.AppRole;
import com.khoapham.model.AppUser;
import com.khoapham.model.UserRole;

public interface IUserRoleService {
    void setUserRoleForNewUser(UserRole userRole, AppRole appRole, AppUser appUser);
}
