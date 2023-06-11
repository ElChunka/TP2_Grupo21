package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegationController {
	
	@GetMapping("/index")
	public String getPageIndex() {
	return "index";
}

}
