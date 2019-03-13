package my.spring5.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.spring5.recipe.domain.Recipe;
import my.spring5.recipe.repository.RecipeRepository;

@Controller
public class RecipeController {
	
	private RecipeRepository recipeRepository;
	

	public RecipeController(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@RequestMapping({"recipe", "recipe.html"})
	public String homePage(Model model) {
		
		Iterable<Recipe> recipes = recipeRepository.findAll();
		
		Recipe recipe = recipes.iterator().next();
		
		model.addAttribute("recipe", recipe);
		
		return "recipe";
	}
	
}
