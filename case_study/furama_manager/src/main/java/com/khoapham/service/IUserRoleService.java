package com.khoapham.service;

import com.khoapham.models.user.AppRole;
import com.khoapham.models.user.AppUser;
import com.khoapham.models.user.UserRole;

public interface IUserRoleService {
    void setUserRoleForNewUser(UserRole userRole, AppRole appRole, AppUser appUser);
}
