package my.spring5.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({"", "/", "index.html"})
	public String homePage() {
		return "index";
	}
	
}
