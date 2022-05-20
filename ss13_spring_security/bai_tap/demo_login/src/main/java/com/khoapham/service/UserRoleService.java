package com.khoapham.service;

import com.khoapham.model.AppRole;
import com.khoapham.model.AppUser;
import com.khoapham.model.UserRole;
import com.khoapham.repository.IUserRoleRepository;
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
