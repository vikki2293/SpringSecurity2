package com.springsecurity.springsecurity.Repository;

import com.springsecurity.springsecurity.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
}
