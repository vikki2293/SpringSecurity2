package com.springsecurity.springsecurity.Repository;

import com.springsecurity.springsecurity.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login,Long> {
    Optional<Login> findByUsername(String username);
}
