package com.khoapham.service;

import models.Account;

public interface ILoginService {

    Account checkLogin(String username, String password);
}
