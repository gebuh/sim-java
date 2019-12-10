package com.boose.sim.controller;

import com.boose.sim.dto.AnimalsDTO;
import com.boose.sim.service.AnimalsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalsController {
    @Autowired
    private AnimalsServiceImpl animalsServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<AnimalsDTO> getAnimals() {
        return animalsServiceImpl.getAnimals();
    }
}
