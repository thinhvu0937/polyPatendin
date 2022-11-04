package polypatemding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import polypatemding.dao.CategoryDAO;
import polypatemding.entity.Category;
import polypatemding.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService CategoryService;
	@Autowired
	CategoryDAO cadao;

	@RequestMapping("/category/form")
	public String form(Model model) {
		Category cate = new Category();
		model.addAttribute("cate", cate);
		
		return "category/form";
	}
	@RequestMapping("/category/table")
	public String table(Model model,
			@Param("keyword") String keyword) {
		List<Category> items = CategoryService.findAll(keyword);
		model.addAttribute("c", items);
		model.addAttribute("keyword", keyword);
		return "category/table";
	}

	//Delete
	@RequestMapping("/cate/delete/{id}")
	public String create(@PathVariable("id") String id) {
		cadao.deleteById(id);
		return "redirect:/category/table";
	}

	// Edit
	@RequestMapping("/cate/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Category item = cadao.findById(id).get();
		model.addAttribute("cate", item);
		List<Category> items = cadao.findAll();
		model.addAttribute("c", items);
		return "category/form";
	}

	@PostMapping(value = "/cate/save")
	public String saves(@ModelAttribute("ca") Category ca) {
		CategoryService.create(ca);
		return "redirect:/category/table";
	}

}
