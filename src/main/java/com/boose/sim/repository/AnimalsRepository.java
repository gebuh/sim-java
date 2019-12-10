package com.boose.sim.repository;

import com.boose.sim.entity.AnimalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<AnimalsEntity, Integer> { }
