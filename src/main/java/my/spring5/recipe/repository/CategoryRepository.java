package my.spring5.recipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import my.spring5.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	Optional<Category> findByDescription(String description);
	
}
