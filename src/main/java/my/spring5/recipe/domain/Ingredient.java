package my.spring5.recipe.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@ToString(exclude = {"recipe"})
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private BigDecimal amount;
	
	@ManyToOne
	private Recipe recipe;
	
	@OneToOne
	private UnitOfMeasure unitOfMeasure;
}
