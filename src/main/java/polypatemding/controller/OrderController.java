package polypatemding.controller;



import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import polypatemding.service.CategoryService;
import polypatemding.service.OrderService;
import polypatemding.service.ProductService;
import polypatemding.entity.Order;
import polypatemding.entity.OrderDetail;
import polypatemding.entity.Product;



@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	CategoryService Cservice;
	@Autowired
	ProductService productService;
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	
	
	@RequestMapping("/order/list")
	public String list(Model model,
			HttpServletRequest req) {
		String username =  req.getRemoteUser();
		model.addAttribute("orders",orderService.findByUsername(username));
		return "order/list";
	}
	
	/*
	 * @RequestMapping("/order/congthuc") public String conghtuc(Model model,
	 * HttpServletRequest req) { String username = req.getRemoteUser();
	 * model.addAttribute("orders",orderService.findByUsername(username)); return
	 * "order/congthuc"; }
	 */
	/*
	 * @RequestMapping("/order/tintuc") public String tintuc(Model model,
	 * HttpServletRequest req) { String username = req.getRemoteUser();
	 * model.addAttribute("orders",orderService.findByUsername(username)); return
	 * "order/tintuc"; }
	 */

	/*
	 * @RequestMapping("/order/lienhe") public String lienhe(Model model,
	 * HttpServletRequest req) { String username = req.getRemoteUser();
	 * model.addAttribute("orders",orderService.findByUsername(username)); return
	 * "order/lienhe"; }
	 */
	
	
	@RequestMapping("/order/congthucchitiet")
	public String congthucchitiet(Model model,
			HttpServletRequest req) {
		String username =  req.getRemoteUser();
		model.addAttribute("orders",orderService.findByUsername(username));
		return "order/congthucchitiet";
	}
	
	@RequestMapping("/order/tintucchitiet")
	public String tintucchitiet(Model model,
			HttpServletRequest req) {
		String username =  req.getRemoteUser();
		model.addAttribute("orders",orderService.findByUsername(username));
		return "order/tintucchitiet";
	}
	
	@RequestMapping("/order/khuyenmai")
	public String list(Model model, @RequestParam("cid")Optional<String> cid,@RequestParam("p") Optional<Integer> p ) {
		
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		if (cid.isPresent()) {			
			polypatemding.entity.Category cate = Cservice.findById(cid).get();
			Page<Product> listProduct1 = productService.findByCategory(cate, pageable);	
			model.addAttribute("items", listProduct1);

		}
		else {						
			 Page<Product> listProduct = productService.findAll(pageable); 
			model.addAttribute("items", listProduct);		
		}
		return "order/khuyenmai";
	}
	
	
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id")Long id,
			Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "order/detail";
	}
	
	@RequestMapping("/orderadmin/form/{id}")
//	public String or(Model model,
//			HttpServletRequest req) {
//		String username =  req.getRemoteUser();
//		model.addAttribute("orders",orderService.findByUsername(username));
//		return "/orderadmin/form";
//	}
	
	public String orderDetail(Model model, @PathVariable Long id) {
		Order order1 = orderService.findById(id);
		model.addAttribute("order", order1);
		
		List<OrderDetail> listbyId = order1.getOrderDetails();
		model.addAttribute("listDetailById", listbyId);
		
		return "/orderadmin/form";
	}
	
	@RequestMapping("/orderadmin/table")
	public String orderDetail(Model model,
			@Param("keyword") String keyword) {
//			@RequestParam("pageNumber") Optional<Integer> currentPage,
//			@RequestParam("sortField") Optional<String> sortField,
//			@RequestParam("sortDir") Optional<String> sortDir) {
//		Pageable pageable = PageRequest.of(currentPage.orElse(0), 9);
		List<Order> listOrder = orderService.findAll(keyword);
		model.addAttribute("listOrder", listOrder);
		model.addAttribute("keyword", keyword);
//		model.addAttribute("sortField", sortField);
//		model.addAttribute("sortDir", sortDir);
		return "/orderadmin/table";
	}
	
	
	@PostMapping("/orderadmin/form/update")
	public String UpdateStatus (Order order  ) {
		orderService.save(order);
		return "redirect:/orderadmin/table";
	}
}
