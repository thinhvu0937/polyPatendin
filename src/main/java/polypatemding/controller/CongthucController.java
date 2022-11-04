package polypatemding.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import polypatemding.entity.Congthuc;
import polypatemding.service.CongthucService;

@Controller
public class CongthucController {
	@Autowired
	CongthucService congthucService;
	//load dữ liệu và phân trang customer
	@RequestMapping("/order/congthuc")
	public String list(Model model,
			@RequestParam("number") Optional<Integer> numberOpt,
			@RequestParam("size") Optional<Integer> sizeOpt) {
		int number = numberOpt.orElse(0);
		int size = sizeOpt.orElse(5);
		Pageable pageable = PageRequest.of(number, size,Direction.DESC,"createDate");
		Page<Congthuc> page = congthucService.findAll(pageable);
		model.addAttribute("page", page);
		return "order/congthuc";
	}

	// gọi nhảy trang
	@RequestMapping("/order/congthuc/detail/{id}")
	public String listcongthuc(Model model, @PathVariable("id") Integer id) {
		Congthuc co = congthucService.findbyid(id);
		model.addAttribute("co", co);
		return "order/congthucchitiet";
	}
}
