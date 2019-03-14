package my.spring5.recepie.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import my.spring5.recipe.controller.IndexController;
import my.spring5.recipe.domain.Recipe;
import my.spring5.recipe.repository.RecipeRepository;

public class IndexControllerTest {

	IndexController indexController;
	
	@Mock RecipeRepository recipeRepository;
	
	@Mock Model model;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeRepository);
	}
	
	@Test
	public void mockMvc() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}
	
	@Test
	public void homePageTest() {
		ArrayList<Recipe> recipes = new ArrayList<>();
		
		Recipe recipe = new Recipe();
		recipe.setName("Test Food");
		recipe.setDescription("Test Desc");
		
		recipes.add(recipe);
		
		when(recipeRepository.findAll()).thenReturn(recipes);
		
		String result = indexController.homePage(model);
		assertEquals("index", result);
		
		verify(recipeRepository, times(1)).findAll();
		verify(model, times(1)).addAttribute("recipes", recipes);
	}
	
	
}
