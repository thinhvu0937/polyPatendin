package polypatemding.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import polypatemding.dao.ProductDAO;
import polypatemding.entity.Category;
import polypatemding.entity.Product;
import polypatemding.service.CategoryService;
import polypatemding.service.ProductService;
@Controller
public class ProductController {
		
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService Cservice;
	
	@Autowired
	ProductDAO productDAO;
	
	//load sản phẩm,phân trang,tìm theo tên sản phẩm lên customer 
	  @RequestMapping("/product/list") public String list(Model model,
	  
	  @RequestParam("field") Optional<String> field,
	  
	  @RequestParam("cid") Optional<String> cid,
	  
	  @RequestParam("p") Optional<Integer> p,
	  
	  @RequestParam("search") Optional<String> search) { Pageable pageable =
	  PageRequest.of(p.orElse(0), 9); if (cid.isPresent()) { Category cate =
	  Cservice.findById(cid).get(); Page<Product> page =
	  productService.findByCategory(cate, pageable); model.addAttribute("pages",
	  new int[page.getTotalPages()]); model.addAttribute("page", page);
	  
	  } else if (search.isPresent()) { Page<Product> page =
	  productService.findByKeyword(search.get(), pageable);
	  model.addAttribute("pages", new int[page.getTotalPages()]);
	  model.addAttribute("page", page); } else { Sort sort =
	  Sort.by(field.orElse("ASC").equalsIgnoreCase("ASC") ? Direction.ASC :
	  Direction.DESC, "price"); pageable = PageRequest.of(p.orElse(0), 9, sort);
	  Page<Product> page = productService.findAll(pageable);
	  model.addAttribute("pages", new int[page.getTotalPages()]);
	  model.addAttribute("page", page); }
	  
	  return "product/list"; }
	 
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id")Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item",item);
		return "product/detail";
	}
		@RequestMapping("/product/form")
	public String form(Model model) {
		Product lienhe = new Product();
		model.addAttribute("prod", lienhe);

		return "product/form";
	}
		@RequestMapping("/product/table")
		public String table(Model model,
				@Param("keyword") String keyword) {
//			String keyword ="nho";
			List<Product> items = productService.findAll(keyword);
			model.addAttribute("p", items);
			model.addAttribute("keyword", keyword);

			return "product/table";
		}

	@ModelAttribute("category")
	public List<Category> listType() {
		return Cservice.findAll();
	}

	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		productDAO.deleteById(id);
		return "redirect:/product/table";
	}

	@RequestMapping("/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Product item = productDAO.findById(id).get();
		model.addAttribute("prod", item);
		List<Product> items = productDAO.findAll();
		model.addAttribute("p", items);
		return "product/form";
	}

	@PostMapping(value = "/product/index/saves")
	public String saves(Product p) {
		 	productService.create(p);
		  
		 	return "redirect:/product/table";
	}

}
