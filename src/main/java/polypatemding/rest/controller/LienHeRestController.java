package polypatemding.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polypatemding.entity.LienHe;
import polypatemding.service.LienHeService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/lienhe")
public class LienHeRestController {
	@Autowired
	LienHeService productService;

	
	@GetMapping()
	public List<LienHe> getAll(){
		return productService.findAll();
	}
	
	@PostMapping()
	public LienHe create(@RequestBody LienHe l) {
		return productService.create(l);
	}
	
	
}
