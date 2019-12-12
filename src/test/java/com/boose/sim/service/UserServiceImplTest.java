package com.boose.sim.service;

import com.boose.sim.dto.UsersDTO;
import com.boose.sim.entity.UsersEntity;
import com.boose.sim.repository.UsersRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;


import static org.mockito.AdditionalAnswers.returnsFirstArg;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    private List<UsersEntity> ueList;
    private UsersEntity ue;
    private UsersDTO usersDTO;

    @BeforeEach
    void setUp() {
        ue = new UsersEntity();
        ue.setPassword("somestring");
        ue.setUsername("Scytale");
        ue.setId(1);
        ueList = List.of(ue);
        usersDTO = new UsersDTO();
        usersDTO.setPassword("anotherstring");
        usersDTO.setUsername("lupin");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUsers() {
        UsersEntity ue = new UsersEntity();
        ue.setPassword("somestring");
        ue.setUsername("Scytale");
        ue.setId(1);

        given(usersRepository.findAll()).willReturn(ueList);
        UsersDTO dto = userService.getUsers().get(0);
        assertThat(dto.getUsername()).isEqualToIgnoringCase("scytale");
    }

    @Test
    void getUser() {
        given(usersRepository.findById(ue.getId())).willReturn(Optional.of(ue));
        given(passwordEncoder.encode(ue.getPassword())).willReturn("uselessness");
        UsersDTO dto = userService.getUser(1);
        assertThat(dto.getUsername()).isEqualToIgnoringCase("scytale");
    }

    @Test
    void addUser() {
        given(usersRepository.save(any(UsersEntity.class))).will(returnsFirstArg());
        given(passwordEncoder.encode(usersDTO.getPassword())).willReturn("uselessness");
        String results = userService.addUser(usersDTO);
        assertThat(results).contains("lupin");
    }

}