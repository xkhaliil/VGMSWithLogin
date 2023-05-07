package com.khalil.vgms.services;

import com.khalil.vgms.dto.RegistrationDto;
import com.khalil.vgms.entities.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    User findUserByUsername(String username);
}