package polypatemding.controller;

import java.security.Provider.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import polypatemding.dao.LienHeDAO;
import polypatemding.entity.LienHe; 

import polypatemding.service.LienHeService;
@Controller
public class LienHeController {
		
	@Autowired
	LienHeService LienHeService ;
	
	@RequestMapping("/order/lienhe")
	  public String list(@ModelAttribute("lh") LienHe l) {
	  
	  return "order/lienhe";
	  }
	 //nút lưu 
	 @PostMapping(value="/save") 
	public String save(@ModelAttribute("lh") LienHe l) {
		LienHeService.create(l);
		return "redirect:/";
	}
}
