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
import org.springframework.web.bind.annotation.RequestParam;

import polypatemding.dao.AccountDAO;
import polypatemding.entity.Account;
import polypatemding.entity.Authority;
import polypatemding.entity.Role;
import polypatemding.service.AccountService;
import polypatemding.service.AuthorityService;
import polypatemding.service.RoleService;

@Controller
public class SignUpAdminController {

	@Autowired
	AccountService AccountService;
	
	@Autowired
	RoleService Roleservice;
	@Autowired
	AuthorityService authservice;
	
	@RequestMapping("/account/form")
	public String form(Model model) {
		Account lienhe = new Account();
		model.addAttribute("acad", lienhe);

		return "account/form";
	}
	@RequestMapping("/account/table")
	public String index(Model model,
			@Param("keyword") String keyword) {
		List<Authority> items= authservice.findAll(keyword);
//		List<Account> items = acdao.findAll();
		model.addAttribute("a", items);
		model.addAttribute("keyword", keyword);
		

		return "account/table";
	}

	@ModelAttribute("role")
	public List<Role> listType() {
		return Roleservice.findAll();
	}

	// Xóa

	@RequestMapping("/account/delete/{userName}")
	public String create(@PathVariable("userName") String userName) {
		AccountService.deleteByid(userName);
		return "redirect:/account/table";
	}
	// Edit

	@RequestMapping("/account/edit/{userName}")
	public String edit(Model model, @PathVariable("userName") String userName) {
		Account item = AccountService.findById(userName);
		model.addAttribute("acad", item);
		/*
		 * List<Account> items = acdao.findAll(); model.addAttribute("a", items);
		 */
		return "account/form";
	}

	@PostMapping(value = "/security/dangki/saves")
	public String saves(@ModelAttribute("acad") Account ac,
			@RequestParam("roleid") String roleid) {
		 AccountService.create(ac,roleid);
		  
		return "redirect:/account/table";
	}

}

