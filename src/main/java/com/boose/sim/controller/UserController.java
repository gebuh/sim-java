package com.boose.sim.controller;

import com.boose.sim.dto.UsersDTO;
import com.boose.sim.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value = "/")
    public List<UsersDTO> getUsers() {
        return this.userServiceImpl.getUsers();
    }

    @GetMapping(value = "/{id}")
    public UsersDTO getUser(@PathVariable("id") int id) {
        return this.userServiceImpl.getUser(id);
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestBody @Valid UsersDTO dto) {
        return userServiceImpl.addUser(dto);
    }

    @DeleteMapping(value = "/remove")
    public String removeUser(@RequestBody UsersDTO dto) {
        return userServiceImpl.deleteUser(dto);
    }



}
