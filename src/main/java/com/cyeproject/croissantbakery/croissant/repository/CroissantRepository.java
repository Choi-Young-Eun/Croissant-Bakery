package com.cyeproject.croissantbakery.croissant.repository;

import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CroissantRepository extends JpaRepository<Croissant,Long> {
    Optional<Croissant> findByCroissantName(String name);
}
