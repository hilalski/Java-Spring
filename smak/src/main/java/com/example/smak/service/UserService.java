package com.example.smak.service;

import com.example.smak.dto.*;
import com.example.smak.model.*;
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
