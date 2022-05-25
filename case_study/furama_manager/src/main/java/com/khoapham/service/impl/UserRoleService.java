package com.khoapham.service.impl;


import com.khoapham.models.user.AppRole;
import com.khoapham.models.user.AppUser;
import com.khoapham.models.user.UserRole;
import com.khoapham.repository.IUserRoleRepository;
import com.khoapham.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public void setUserRoleForNewUser(UserRole userRole, AppRole appRole, AppUser appUser) {
        userRole.setAppUser(appUser);
        userRole.setAppRole(appRole);
        this.iUserRoleRepository.save(userRole);
    }
}
