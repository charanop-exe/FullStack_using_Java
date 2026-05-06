package edu.sample;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProductController {
	@GetMapping("Product")
	public String productService() {
		return "product Service pages can be loaded here";
	}

}
