package polypatemding.rest.controller;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polypatemding.entity.LienHe;
import polypatemding.entity.Tintuc;
import polypatemding.service.TintucService;

@CrossOrigin("*") // có hay không cũng được(để host có thể truy vấn)
@RestController
@RequestMapping("/rest/tintuc")
public class TintucRestController {
	@Autowired
	TintucService tintucService;

	/*
	 * @GetMapping() public List<Tintuc> getAll() { return tintucService.findAll();
	 * }
	 */

	@PostMapping()
	public Tintuc create(@RequestBody Tintuc n) {
		return tintucService.create(n);
	}
}
