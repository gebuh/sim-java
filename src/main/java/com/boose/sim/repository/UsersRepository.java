package com.boose.sim.repository;

import com.boose.sim.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    List<UsersEntity> findByUsername(String username);
    List<UsersEntity> deleteByUsername(String username);
    Optional<UsersEntity> findFirstByUsername(String username);
}
