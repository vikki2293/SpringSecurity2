package com.springsecurity.springsecurity.Controller;

import com.springsecurity.springsecurity.Model.Login;
import com.springsecurity.springsecurity.Service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private LoginService service;

    @GetMapping("/")
    public String hello(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        return "session-id "+ session.getId();
    }

    @PostMapping("/create")
    public void createLogin(@RequestBody Login login)
    {
    service.createUser(login);
    }
}
