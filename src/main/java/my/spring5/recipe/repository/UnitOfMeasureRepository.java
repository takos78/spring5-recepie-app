package my.spring5.recipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import my.spring5.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{

	Optional<UnitOfMeasure> findByDescription(String description);
	
}
