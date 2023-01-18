package com.example.genderapi.repository;

import com.example.genderapi.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenderRepository extends JpaRepository<GenderEntity, Long> {
    Optional<GenderEntity> findGenderEntityByName(String name);
}
