package my.spring5.recipe.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude = {"note", "ingredients", "categories", "image"})
@ToString(exclude = {"note", "ingredients", "categories", "image"})
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private Integer prepTime;
	
	private Integer cookTime;
	
	private Integer servings;
	
	private String source;
	
	private String url;
	
	private String directions;
	
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	
	@Lob
	private Byte[] image;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Note note;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "RECIPE_CATEGORY", 
		joinColumns = @JoinColumn(name = "recipe_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
}
