package com.boose.sim.controller;

import com.boose.sim.dto.AnimalsDTO;
import com.boose.sim.dto.UsersDTO;
import com.boose.sim.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UsersDTO> getUsers() {
        return this.userServiceImpl.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UsersDTO getUser(@PathVariable("id") int id) {
        return this.userServiceImpl.getUser(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestBody UsersDTO dto) {
        return userServiceImpl.addUser(dto);
    }



}
