package pl.bodzio.superproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bodzio.superproject.model.Book;

@Controller
public class SimpleController {
	@Value("${spring.application.name}")
	String appName;

	@GetMapping("/")
	public String greetingForm(Model model) {
		model.addAttribute("appName", appName);
		model.addAttribute("book", new Book());
		return "home";
	}

/*	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute
			Book book) {
		return "result";
	}*/
}
