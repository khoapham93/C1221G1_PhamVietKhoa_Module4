package com.khoapham.dto;

import com.khoapham.model.AppRole;
import com.khoapham.model.AppUser;

public class UserRoleDto {
    private Long id;
    private AppUser appUser;
    private AppRole appRole;

    public UserRoleDto(Long id, AppUser appUser, AppRole appRole) {
        this.id = id;
        this.appUser = appUser;
        this.appRole = appRole;
    }
    public UserRoleDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
