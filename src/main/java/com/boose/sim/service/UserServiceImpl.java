package com.boose.sim.service;

import com.boose.sim.dto.UsersDTO;
import com.boose.sim.entity.UsersEntity;
import com.boose.sim.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {
    @Autowired
    private UsersRepository usersRepository;

    public List<UsersDTO> getUsers() {
        List<UsersEntity> ueList = usersRepository.findAll();
        return ueList.stream().map(ue -> this.convertUE_DTO(ue)).collect(Collectors.toList());
    }

    public UsersDTO getUser(int id) {
        UsersEntity ue = usersRepository.findById(id).orElseThrow(()
                -> new UsernameNotFoundException("User with id : " + id + " not found"));
        return this.convertUE_DTO(ue);
    }

    public String addUser(UsersDTO dto) {
        UsersEntity ue = new UsersEntity();
        ue.setPassword(dto.getPassword());
        ue.setUsername(dto.getUsername());
        usersRepository.save(ue);
        return dto.getUsername() + " saved";
    }

    private UsersDTO convertUE_DTO(UsersEntity ue) {
        UsersDTO dto = new UsersDTO();
        dto.setId(ue.getId());
        dto.setPassword(ue.getPassword());
        dto.setUsername(ue.getPassword());
        return dto;
    }
}

