package com.khoapham.repository.impl;

import models.Account;
import repository.BaseRepository;
import repository.ILoginRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepositoryImpl implements ILoginRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ACCOUNT = "SELECT username, password, `name`,`role` from account where username = ? and password =?;";
    @Override
    public Account chekLogin(String username, String password) {
        Account account = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ACCOUNT);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            String usernameData;
            String passwordData;
            String nameData;
            String role;
            while (resultSet.next()){
                usernameData = resultSet.getString("username");
                passwordData = resultSet.getString("password");
                nameData = resultSet.getString("name");
                role = resultSet.getString("role");

                account = new Account(usernameData,passwordData,nameData,role);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return account;
    }
}
