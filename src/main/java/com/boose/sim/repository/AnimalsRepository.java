package com.boose.sim.repository;

import com.boose.sim.entity.AnimalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalsRepository extends JpaRepository<AnimalsEntity, Integer> {

    List<AnimalsEntity> findBySpecies(String species);
    List<AnimalsEntity> deleteByNameAndAndSpecies(String name, String species);
}
