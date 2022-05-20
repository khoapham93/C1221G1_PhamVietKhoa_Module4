package com.khoapham.repository;

import com.khoapham.model.AppUser;
import com.khoapham.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
