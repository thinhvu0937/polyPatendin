package polypatemding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import polypatemding.entity.Account;
import polypatemding.service.AccountService;

@Controller
public class SignUpController {
	@Autowired
	AccountService SignUpService ;

	
	@RequestMapping("/security/dangki")
	public String list(Model model) {
		Account account = new Account();
		model.addAttribute("acc", account);
		return "security/dangki";
}
	// customer tạo tài khoản
	@PostMapping(value="/security/dangki/save") 
	public String save(Account ac) {
		
		SignUpService.create(ac,"CUST");
		return "redirect:/";
	}
}
