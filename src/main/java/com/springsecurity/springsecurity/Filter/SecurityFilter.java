package com.springsecurity.springsecurity.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFilter {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception
    {
        security.csrf(csrf -> csrf.disable()).
                authorizeHttpRequests(auth -> auth.requestMatchers("/","/create","/delete**").
                permitAll().anyRequest().authenticated()).
                httpBasic(httpbasic ->{}).
                formLogin(form -> form.permitAll());

        return security.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder)
    {
        UserDetails details = User.withUsername("Vikki").password(encoder.encode("Test")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(details);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
