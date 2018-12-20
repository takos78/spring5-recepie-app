package my.spring5.recipe.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import my.spring5.recipe.domain.Category;
import my.spring5.recipe.domain.Difficulty;
import my.spring5.recipe.domain.Ingredient;
import my.spring5.recipe.domain.Note;
import my.spring5.recipe.domain.Recipe;
import my.spring5.recipe.domain.UnitOfMeasure;
import my.spring5.recipe.repository.CategoryRepository;
import my.spring5.recipe.repository.RecipeRepository;
import my.spring5.recipe.repository.UnitOfMeasureRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private CategoryRepository catRepo;
	
	private UnitOfMeasureRepository uomRepo;
	
	private RecipeRepository recipeRepo;
	
	
	
	public DataLoader(CategoryRepository catRepo, UnitOfMeasureRepository uomRepo, RecipeRepository recipeRepo) {
		this.catRepo = catRepo;
		this.uomRepo = uomRepo;
		this.recipeRepo = recipeRepo;
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Loading Data...");
		loadData();		
	}

	private void loadData() {
		
		Recipe recipe1 = new Recipe();
		
		Category cat1 = catRepo.findByDescription("American").get();
		Category cat2 = catRepo.findByDescription("Italian").get();
		cat1.getRecipes().add(recipe1);
		cat2.getRecipes().add(recipe1);
		
		UnitOfMeasure uomCup = uomRepo.findByDescription("Cup").get();
		UnitOfMeasure uomPinch = uomRepo.findByDescription("Pinch").get();
		
		recipe1.addIngredient(new Ingredient("tea", new BigDecimal(2.5), uomCup));
		recipe1.addIngredient(new Ingredient("stuff", new BigDecimal(1.5), uomPinch));
		
		recipe1.addNote(new Note("Note1: This should be delicious!"));
		
		recipe1.setDifficulty(Difficulty.MODERATE);
		recipe1.setDirections("Cook it well");
		
		recipe1.getCategories().add(cat1);
		recipe1.getCategories().add(cat2);
				
		recipe1.setCookTime(2);
		recipe1.setDescription("This text should explain what it is (description)");
		recipe1.setPrepTime(1);
		recipe1.setServings(2);
		recipe1.setSource("Source1");
		recipe1.setUrl("www.whatisthis.com/i/do/not/know");
		
		Recipe savedRecipe = recipeRepo.save(recipe1);
		
		System.out.println("Recipe saved:");
		System.out.println(savedRecipe);
		
	}

}
