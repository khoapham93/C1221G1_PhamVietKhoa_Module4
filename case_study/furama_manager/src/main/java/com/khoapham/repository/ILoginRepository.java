package com.khoapham.repository;

import models.Account;

public interface ILoginRepository {

    Account chekLogin(String username, String password);
}
