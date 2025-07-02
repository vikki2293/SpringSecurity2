package com.springsecurity.springsecurity.Service;

import com.springsecurity.springsecurity.Model.Login;
import com.springsecurity.springsecurity.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository)
    {
        this.loginRepository=loginRepository;
    }

    public void createUser(Login login)
    {
       login.setPassword(passwordEncoder.encode(login.getPassword()));
       loginRepository.save(login);

    }

    public void deleteById(Long id)
    {
        loginRepository.deleteById(id);
    }

}
