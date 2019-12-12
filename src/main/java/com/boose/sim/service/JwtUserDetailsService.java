package com.boose.sim.service;

import com.boose.sim.dto.UsersDTO;
import com.boose.sim.entity.UsersEntity;
import com.boose.sim.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity ue = this.usersRepository.findFirstByUsername(username).orElseThrow(()
                -> new UsernameNotFoundException("Username: " + username + " not found"));
        return new org.springframework.security.core.userdetails.User(ue.getUsername(), ue.getPassword(),
                true, true, true, true, new ArrayList<>());
    }

}
