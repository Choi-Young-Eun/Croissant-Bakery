package com.cyeproject.croissantbakery.croissant.repository;

import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CroissantRepository extends JpaRepository<Croissant,Long> {
}
