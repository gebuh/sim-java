package com.boose.sim.service;

import com.boose.sim.dto.UsersDTO;
import com.boose.sim.entity.UsersEntity;
import com.boose.sim.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsersDTO> getUsers() {
        List<UsersEntity> ueList = usersRepository.findAll();
        return ueList.stream().map(ue -> this.convertUE_DTO(ue)).collect(Collectors.toList());
    }

    public UsersDTO getUser(int id) {
        UsersEntity ue = usersRepository.findById(id).orElseThrow(()
                -> new UsernameNotFoundException("User with id : " + id + " not found"));
        ue.setPassword(passwordEncoder.encode(ue.getPassword()));
        return this.convertUE_DTO(ue);
    }

    public String addUser(UsersDTO dto) {
        UsersEntity ue = new UsersEntity();
        ue.setPassword(passwordEncoder.encode(dto.getPassword()));
        ue.setUsername(dto.getUsername());
        usersRepository.save(ue);
        return dto.getUsername() + " saved";
    }

    public String deleteUser(UsersDTO dto) {
        usersRepository.deleteByUsername(dto.getUsername());
        return dto.getUsername() + " removed";
    }

    private UsersDTO convertUE_DTO(UsersEntity ue) {
        UsersDTO dto = new UsersDTO();
        dto.setId(ue.getId());
        dto.setPassword(ue.getPassword());
        dto.setUsername(ue.getUsername());
        return dto;
    }
}

