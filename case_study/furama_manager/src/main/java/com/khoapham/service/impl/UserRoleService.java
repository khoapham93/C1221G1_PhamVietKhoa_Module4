package com.khoapham.service.impl;

import com.khoapham.models.employee.Employee;
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
    public void setUserRoleForNewUser(Employee employee, AppRole roleUser, AppRole roleAdmin, AppUser appUser) {
        // check position of emplyee
        if (employee.getPosition().getId() == 1) {
            UserRole userRoleAdmin = new UserRole();
            userRoleAdmin.setAppUser(appUser);
            userRoleAdmin.setAppRole(roleAdmin);
            this.iUserRoleRepository.save(userRoleAdmin);
        }
        UserRole userRoleUser = new UserRole();
        userRoleUser.setAppUser(appUser);
        userRoleUser.setAppRole(roleUser);
        this.iUserRoleRepository.save(userRoleUser);
    }
}
