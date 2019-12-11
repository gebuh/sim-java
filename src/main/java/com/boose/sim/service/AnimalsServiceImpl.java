package com.boose.sim.service;

import com.boose.sim.dto.AnimalsDTO;
import com.boose.sim.entity.AnimalsEntity;
import com.boose.sim.repository.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalsServiceImpl {
    @Autowired
    private AnimalsRepository animalsRepository;

    public List<AnimalsDTO> getAnimals(){
        List<AnimalsEntity> aelist = animalsRepository.findAll();
        return aelist.stream().map(ae -> this.convertAE_DTO(ae)).collect(Collectors.toList());
    }

    public AnimalsDTO getAnimal(int id) {
        AnimalsEntity ae = animalsRepository.findById(id).orElse(null);
        return convertAE_DTO(ae);
    }

    public List<AnimalsDTO> getSpecies(String species) {
        List<AnimalsEntity> aelist = animalsRepository.findBySpecies(species);
        return aelist.stream().map(ae -> this.convertAE_DTO(ae)).collect(Collectors.toList());
    }

    public String addAnimal(AnimalsDTO dto) {
        AnimalsEntity ae = new AnimalsEntity();
        ae.setName(dto.getName());
        ae.setSpecies(dto.getSpecies());
        animalsRepository.save(ae);
        return dto.getName() + " saved";
    }

    public String deleteAnimal(AnimalsDTO dto) {
        animalsRepository.deleteByNameAndAndSpecies(dto.getName(), dto.getSpecies());
        return dto.getName() + " removed";
    }


    private AnimalsDTO convertAE_DTO(AnimalsEntity ae) {
        AnimalsDTO dto = new AnimalsDTO();
        dto.setId(ae.getId());
        dto.setName(ae.getName());
        dto.setSpecies(ae.getSpecies());
        return dto;
    }


}
