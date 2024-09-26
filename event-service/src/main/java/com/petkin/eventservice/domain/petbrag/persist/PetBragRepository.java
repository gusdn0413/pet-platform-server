package com.petkin.eventservice.domain.petbrag.persist;

import com.petkin.eventservice.domain.petbrag.entity.PetBrag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetBragRepository extends JpaRepository<PetBrag, Long> {
}
