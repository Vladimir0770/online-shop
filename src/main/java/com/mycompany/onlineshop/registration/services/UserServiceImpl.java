package com.mycompany.onlineshop.registration.services;

import com.mycompany.onlineshop.configs.SecurityConfig;
import com.mycompany.onlineshop.entities.Role;
import com.mycompany.onlineshop.entities.User;
import com.mycompany.onlineshop.registration.dto.UserRegistrationDto;
import com.mycompany.onlineshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private final SecurityConfig securityConfig;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, SecurityConfig securityConfig) {
        this.userRepository = userRepository;
        this.securityConfig = securityConfig;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getUsername(), userRegistrationDto.getEmail(),
                securityConfig.passwordEncoder().encode(userRegistrationDto.getPassword()),
                List.of(new Role("ROLE_USER")));

        return userRepository.save(user);
    }
}
