package com.example.demo.service.impl;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initAdmin() {
        UserEntity adminSchroedinger = new UserEntity()
                .setUsername("Schroedinger")
                .setFirstName("sc")
                .setLastName("Kim")
                .setPassword(passwordEncoder.encode("Ichladedichein"))
                .setEmail("schroedinger@gmail.com")
                .setRole("ADMIN");
        userRepository.save(adminSchroedinger);
//
//        UserEntity userEntityAdmin = new UserEntity()
//                .setUsername("admin")
//                .setFirstName("admin")
//                .setLastName("admin ")
//                .setPassword(passwordEncoder.encode("1234"))
//                .setEmail("admin@abv.bg")
//                .setRole("ADMIN");
//        userRepository.save(userEntityAdmin);

    }


}
