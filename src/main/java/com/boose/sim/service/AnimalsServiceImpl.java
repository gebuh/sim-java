package com.boose.sim.service;

import com.boose.sim.dto.AnimalsDTO;
import com.boose.sim.entity.AnimalsEntity;
import com.boose.sim.repository.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalsServiceImpl {
    @Autowired
    private AnimalsRepository animalsRepository;

    public List<AnimalsDTO> getAnimals(){
        List<AnimalsDTO> animalsDTOList = new ArrayList();
        List<AnimalsEntity> animalsEntityList = animalsRepository.findAll();
        AnimalsDTO dto = null;
        for(AnimalsEntity ae : animalsEntityList) {
            dto = new AnimalsDTO();
            dto.setId(ae.getId());
            dto.setName(ae.getName());
            dto.setSpecies(ae.getSpecies());
            animalsDTOList.add(dto);
        }
        return animalsDTOList;
    }

}
