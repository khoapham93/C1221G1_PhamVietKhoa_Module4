package com.khoapham.repository;

import com.khoapham.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserReopsitory extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String uerName);
}
