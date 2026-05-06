package edu.sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
	@GetMapping("home")
	public String msg() {
		return "I am the home Service.you can create home";
	}

}
