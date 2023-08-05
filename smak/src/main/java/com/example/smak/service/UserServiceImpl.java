package com.example.smak.service;


import com.example.smak.dto.*;
import com.example.smak.mapper.*;
import com.example.smak.repository.*;
import com.example.smak.model.*;
import com.example.smak.util.TbConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import static com.example.smak.mapper.UserMapper.mapToUser;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{
    @Autowired UserRepository userRepository;

    @Autowired PasswordEncoder passwordEncoder;

    @Autowired private RoleRepository roleRepository;

    @Override
    public void saveUser(UserDto userDto) {
        Role role = roleRepository.findByName(TbConstants.Roles.USER);

        if (role == null)
            role = roleRepository.save(new Role(TbConstants.Roles.USER));

        User user;
        user = new User(
                userDto.getName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                Arrays.asList(role)
        );
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
