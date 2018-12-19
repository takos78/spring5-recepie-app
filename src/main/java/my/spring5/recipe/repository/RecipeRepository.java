package my.spring5.recipe.repository;

import org.springframework.data.repository.CrudRepository;

import my.spring5.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
