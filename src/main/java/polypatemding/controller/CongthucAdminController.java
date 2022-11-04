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

import polypatemding.dao.CongthucDAO;
import polypatemding.entity.Congthuc;
import polypatemding.entity.Tintuc;
import polypatemding.service.CongthucService;
import polypatemding.service.TintucService;

@Controller
public class CongthucAdminController {
	@Autowired
	CongthucService congthucService;

	// Xử lý dữ liệu
	@RequestMapping("/recipe/form")
	public String form(Model model) {
		Congthuc congthuc = new Congthuc();
		model.addAttribute("rp", congthuc); 
		return "recipe/form";
	}
	// Xử lý dữ liệu
	@RequestMapping("/recipe/table")
	public String index(Model model,
			@Param("keyword") String keyword) {
		 List<Congthuc> items = congthucService.findAll(keyword); 
		 model.addAttribute("p", items); 
		 model.addAttribute("keyword", keyword);
		return "recipe/table";
	}

//nút xóa(xóa theo khóa chính)
	@RequestMapping("recipe/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		congthucService.delete(id);
		return "redirect:/recipe/table";
	}

//nút edit
	@RequestMapping("/recipe/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Congthuc item = congthucService.findbyid(id);// lấy dữ liệu ra
		model.addAttribute("rp", item);
		List<Congthuc> items = congthucService.listAll();
		model.addAttribute("p", items);
		return "recipe/form";

	}

//nút thêm
	@PostMapping(value = "/recipe/save")
	public String save(@ModelAttribute("rp") Congthuc p) {
		congthucService.create(p);
		return "redirect:/recipe/table";
	}
}
