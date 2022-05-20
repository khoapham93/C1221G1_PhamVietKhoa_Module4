package com.khoapham.repository;

import com.khoapham.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole,Long> {
}
