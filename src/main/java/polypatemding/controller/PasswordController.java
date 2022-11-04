package polypatemding.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import polypatemding.entity.Account;
import polypatemding.entity.CustomerUserDetails;
import polypatemding.service.AccService;

@Controller
public class PasswordController {
	@Autowired
	private AccService accService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/security/change_password")
	public String showChangePasswordForm(Model model) {
		model.addAttribute("pageTitle", "Change Expired Password");
		return "security/change_password";
	}

	@Autowired
	BCryptPasswordEncoder pe;
	
	@PostMapping("/security/change_password")
	public String processChangePassword(HttpServletRequest request, HttpServletResponse response, Model model,
			RedirectAttributes ra, Authentication authentication) throws ServletException {
		

		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		
		if(!newPassword.equals(confirmPassword)) {
			model.addAttribute("message", "Xác nhận mật khẩu không đúng");
			return "security/change_password";
		}
		
		CustomerUserDetails userDetails = (CustomerUserDetails) authentication.getPrincipal();
		Account account = userDetails.getAccount();
		
		String password = pe.encode(newPassword);
		if (passwordEncoder.matches(oldPassword, password)) {
			model.addAttribute("message", "Mật khẩu mới giống mật khẩu cũ");
			return "security/change_password";

		}

		accService.changePassword(account, password);
		request.logout();
		
		ra.addFlashAttribute("message", "Bạn đã thay đổi mật khẩu thành công. Vui lòng đăng nhập lại.");

		return "security/login";
	}
}
