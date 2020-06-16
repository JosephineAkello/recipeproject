package com.example.recipeproject.repositories;

import java.util.Optional;

import com.example.recipeproject.domain.UnitofMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasureRepository, Long> {

    Optional<UnitofMeasure> findByDescription(String description);
}
