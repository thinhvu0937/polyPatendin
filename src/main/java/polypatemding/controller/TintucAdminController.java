package polypatemding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import polypatemding.dao.TintucDAO;
import polypatemding.entity.Tintuc;
import polypatemding.service.TintucService;

@Controller
public class TintucAdminController {
	@Autowired
	TintucService tintucService;


	@RequestMapping("/news/form")
	public String form(Model model) {
		Tintuc tintuc = new Tintuc();
		model.addAttribute("ne", tintuc);
		
		return "news/form";
	}
	@RequestMapping("/news/table")
	public String index(Model model,
			@Param("keyword") String keyword) {
		List<Tintuc> items = tintucService.findAll(keyword);
		model.addAttribute("n", items);
		model.addAttribute("keyword", keyword);
		return "news/table";
	}


	// nút xóa
	@RequestMapping("/news/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		tintucService.delete(id);
		return "redirect:/news/table";
		
		
	}

	// nút edit
	@RequestMapping("/news/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Tintuc item = tintucService.finbyid(id);
		model.addAttribute("ne", item);
		List<Tintuc> items = tintucService.listAll();
		model.addAttribute("n",items);
		return "news/form";

	}

	
	  // nút thêm
	  
	  @PostMapping(value = "/tintuc/save") 
	  public String save(@ModelAttribute("ne") Tintuc n) {
		  tintucService.create(n); 
		  return "redirect:/news/table"; 
		  }
	 
}