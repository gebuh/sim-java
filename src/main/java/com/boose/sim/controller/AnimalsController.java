package com.boose.sim.controller;

import com.boose.sim.dto.AnimalsDTO;
import com.boose.sim.service.AnimalsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AnimalsDTO getAnimal(@PathVariable("id") int id) {
        return animalsServiceImpl.getAnimal(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAnimal(@RequestBody AnimalsDTO dto) {
        return animalsServiceImpl.addAnimal(dto);
    }

    @RequestMapping(value = "/species/{species}", method = RequestMethod.GET)
    public List<AnimalsDTO> getSpecies(@PathVariable("species") String species) {
        return animalsServiceImpl.getSpecies(species);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeAnimal(@RequestBody AnimalsDTO dto) {
        return animalsServiceImpl.deleteAnimal(dto);
    }
}
