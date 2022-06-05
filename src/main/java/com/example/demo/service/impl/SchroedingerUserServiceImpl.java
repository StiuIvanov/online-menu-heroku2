package com.example.demo.service.impl;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchroedingerUserServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public SchroedingerUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + username +" not found!"));

        return mapToUserDetails(userEntity);
    }


    private static UserDetails mapToUserDetails(UserEntity userEntity){

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + "ADMIN");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(simpleGrantedAuthority);

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                simpleGrantedAuthorities
        );
    }
}
