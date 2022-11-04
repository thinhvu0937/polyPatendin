package polypatemding.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import polypatemding.entity.Tintuc;
import polypatemding.service.TintucService;

@Controller
public class TintucController {
	@Autowired
	TintucService tintucService;
	//truy xuất trong db
	@RequestMapping("/order/tintuc")
	public String listTintuc(Model model, 
			@RequestParam("number") Optional<Integer> numberOpt, 
			@RequestParam("size") Optional<Integer> sizeOpt) {
		int number = numberOpt.orElse(0);
		int size = sizeOpt.orElse(5);//số lượng bài trên 1 trang
		Pageable pageable = PageRequest.of(number, size, Direction.DESC, "createDate");
		Page<Tintuc> page = tintucService.findAll(pageable);
		model.addAttribute("page", page);

		return "order/tintuc";
	}
	
	// nhảy trang tintuc chi tiết
	@RequestMapping("/order/tintuc/detail/{id}")
	public String listTintuc(Model model, @PathVariable("id") Integer id) {

		Tintuc tin = tintucService.finbyid(id);
		model.addAttribute("tin", tin);

		return "order/tintucchitiet";
	}

}
