package polypatemding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import polypatemding.entity.OrderDetail;
import polypatemding.entity.TongHop;
import polypatemding.service.TongHopService;

@Controller
public class TongHopController {
	@Autowired
	TongHopService tonghopService;
	//tạo 1 list load dữ liệu từ orderdetail
	@ResponseBody
	@RequestMapping("/api/tong-hop")
	public List<TongHop> getTongHop(){
		List<TongHop> list = tonghopService.getTongHopList();
		return list;
	}
	//đổ biểu đồ lên form
	@RequestMapping("/api/tonghop")
	public String index(Model model) {
		OrderDetail or = new OrderDetail();
		model.addAttribute("tq",or);
		
		return "api/tong-hop";
	}
}
