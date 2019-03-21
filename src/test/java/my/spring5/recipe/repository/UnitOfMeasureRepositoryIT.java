package my.spring5.recipe.repository;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import my.spring5.recipe.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
	
	@Autowired
	public UnitOfMeasureRepository repository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testFindByDescription() {
		Optional<UnitOfMeasure> uom = repository.findByDescription("Teaspoon");
		
		assertEquals("Teaspoon", uom.get().getDescription());
	}

}
