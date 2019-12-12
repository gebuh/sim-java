package com.boose.sim.controller;

import com.boose.sim.dto.UsersDTO;
import com.boose.sim.entity.UsersEntity;
import com.boose.sim.repository.UsersRepository;
import com.boose.sim.service.UserServiceImpl;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UsersRepository usersRepository;



    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
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

        given(usersRepository.findAll()).willReturn(List.of(ue));

        final UsersDTO dto = userController.getUsers().get(0);
        assertThat(dto.getUsername()).isEqualToIgnoringCase(ue.getUsername());
    }

    @Test
    void getUser() {
    }

    @Test
    void addUser() {
    }

    @Test
    void removeUser() {
    }


}