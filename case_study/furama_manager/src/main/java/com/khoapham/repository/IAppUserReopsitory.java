package com.khoapham.repository;

import com.khoapham.models.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserReopsitory extends JpaRepository<AppUser, Integer> {
    AppUser findByUserNameAndEnabled(String uerName,Boolean enable);
}
