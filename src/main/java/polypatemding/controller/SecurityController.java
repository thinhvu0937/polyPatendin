package polypatemding.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/security/login/form")
	public String login(Model model, Authentication auth) {
		model.addAttribute("message","Vui lòng đăng nhập");
		return "security/login";
	}
	

		@RequestMapping("/security/dangki/form")
		public String dangki(Model model) {
			model.addAttribute("message","Vui lòng nhập đầy đủ thông tin");
			return "security/dangki";
		}
		@RequestMapping("/security/quenmk/form")
		public String quenmk(Model model) {
			model.addAttribute("message","Vui lòng nhập đầy đủ thông tin");
			return "security/quenmk";
		}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message","Đăng nhập thành công");
		return "security/login";
	}
	
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message","Sai thông tin đăng nhập");
		return "security/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message","Không có quyền truy xuất");
		return "security/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message","Bạn đã đăng xuất");
		return "security/login";
	}
	

}
