package com.example.validate_register_form.repository;

import com.example.validate_register_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
