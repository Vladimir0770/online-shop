package com.mycompany.onlineshop.registration.services;

import com.mycompany.onlineshop.entities.User;
import com.mycompany.onlineshop.registration.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
}
