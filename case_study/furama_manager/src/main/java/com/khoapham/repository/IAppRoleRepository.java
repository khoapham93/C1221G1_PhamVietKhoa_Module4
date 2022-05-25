package com.khoapham.repository;


import com.khoapham.models.user.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole,Integer> {
}
