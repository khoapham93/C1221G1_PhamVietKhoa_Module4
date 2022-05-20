package com.khoapham.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AppUserDto implements Validator {
    private Long userId;
    private String userName;
    private String encrytedPassword;
    private String rePassword;
    private boolean enabled;

    public AppUserDto(Long userId, String userName, String encrytedPassword, String rePassword, boolean enabled) {
        this.userId = userId;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        this.rePassword = rePassword;
        this.enabled = enabled;
    }

    public AppUserDto(String userName, String encrytedPassword, String rePassword, boolean enabled) {
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        this.rePassword = rePassword;
        this.enabled = enabled;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public AppUserDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AppUserDto appUserDto = (AppUserDto) target;

        String userName = appUserDto.getUserName();
        if ("".equals(userName)){
            errors.rejectValue("userName","userName.empty");
        }
        String passWord = appUserDto.getEncrytedPassword();
        String rePassWord = appUserDto.getRePassword();
        if ("".equals(passWord)){
            errors.rejectValue("encrytedPassword","password.empty");
        }else if (!passWord.equals(rePassWord)){
            errors.rejectValue("rePassword","password.match");
        }
    }
}
