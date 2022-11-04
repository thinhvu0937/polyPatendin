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


import polypatemding.dao.LienHeDAO;
import polypatemding.entity.LienHe;
import polypatemding.service.LienHeService;
@Controller
public class ContactAdminController {
		
	@Autowired
	LienHeService LienHeService ;

	
	
	  @RequestMapping("/contact/form") 
	  public String form(Model model) { 
		  LienHe lienhe = new LienHe(); 
		  model.addAttribute("ct",lienhe); 
		  
		  return "contact/form"; 
		  }
	  @RequestMapping("/contact/table") 
	  public String table(Model model,
			  @Param("keyword") String keyword) {
//		  String keyword ="tài";
		  LienHe lienhe = new LienHe(); 
		  model.addAttribute("ct",lienhe); 
		  List<LienHe> items = LienHeService.findAll(keyword); 
		  
		  model.addAttribute("t", items); 
		  model.addAttribute("keyword", keyword);
		  return "contact/table"; 
		  }
	  //Xóa
	  @RequestMapping("/contact/delete/{name}")
		public String create(@PathVariable("name") String name) {
			LienHeService.delete(name);
			return "redirect:/contact/table";
		}
	  //Edit
	  @RequestMapping("/contact/edit/{name}")
		public String edit(Model model, @PathVariable("name") String name) {
			LienHe item = LienHeService.finbyid(name);
			model.addAttribute("ct",item);
			List<LienHe> items = LienHeService.findAll();
			model.addAttribute("t",items);
			return "contact/form";
		}
	
	 
	 
		
		/*
		 * @RequestMapping("/edit/{name}") public String edit(Model
		 * model, @PathVariable("name") String name) { LienHe item =
		 * dao.findById(name).get(); model.addAttribute("item",item); List<LienHe> items
		 * = dao.findAll(); model.addAttribute("items",items); return "contact/index"; }
		 */
		 
				
				
		/*
		 * @RequestMapping("/contact/index") public String list(@ModelAttribute("ct")
		 * LienHe l) {
		 * 
		 * return "contact/index"; }
		 */
				 
				  
				  
				
				  @PostMapping(value="/saves") 
				  public String saves(@ModelAttribute("ct") LienHe l) { 
					  LienHeService.create(l); 
					  return "redirect:/contact/table"; }
				 
				 
	 
}
