package my.spring5.recepie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({"", "/", "index.html"})
	public String homePage() {
		return "index";
	}
	
}
