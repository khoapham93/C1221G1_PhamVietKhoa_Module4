package com.khoapham.validation_register_form.repository;

import com.khoapham.validation_register_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
