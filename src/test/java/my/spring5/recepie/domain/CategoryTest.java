package my.spring5.recepie.domain;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import my.spring5.recipe.domain.Category;

public class CategoryTest {
	
	private Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void getId() {
		category.setId(4L);
		assertEquals(4L, category.getId().longValue());
	}

	@Test
	public void getDescription() {
		
	}

	@Test
	public void getRecipes() {
		
	}
	
	
}
