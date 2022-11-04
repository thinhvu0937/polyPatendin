package polypatemding.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polypatemding.entity.Congthuc;
import polypatemding.entity.Tintuc;
import polypatemding.service.CongthucService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/congthuc")
public class CongthucRestController {
	@Autowired
	CongthucService congthucService;
	


	@PostMapping()
	public Congthuc create(@RequestBody Congthuc c) {
		return congthucService.create(c);

	}
}
