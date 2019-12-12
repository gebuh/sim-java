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

    @GetMapping(value = "/")
    public List<AnimalsDTO> getAnimals() {
        return animalsServiceImpl.getAnimals();
    }

    @GetMapping(value = "/{id}")
    public AnimalsDTO getAnimal(@PathVariable("id") int id) {
        return animalsServiceImpl.getAnimal(id);
    }

    @PostMapping(value = "/add")
    public String addAnimal(@RequestBody AnimalsDTO dto) {
        return animalsServiceImpl.addAnimal(dto);
    }

    @GetMapping(value = "/species/{species}")
    public List<AnimalsDTO> getSpecies(@PathVariable("species") String species) {
        return animalsServiceImpl.getSpecies(species);
    }

    @DeleteMapping(value = "/remove")
    public String removeAnimal(@RequestBody AnimalsDTO dto) {
        return animalsServiceImpl.deleteAnimal(dto);
    }
}
