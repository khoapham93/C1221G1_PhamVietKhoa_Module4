package com.khoapham.dto;

public class AppRoleDto {
    private Long roleId;
    private String roleName;

    public AppRoleDto(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
    public AppRoleDto(){}

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
