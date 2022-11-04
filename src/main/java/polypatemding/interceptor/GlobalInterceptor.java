package polypatemding.interceptor;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import polypatemding.entity.Congthuc;
import polypatemding.service.CategoryService;
import polypatemding.service.CongthucService;
import polypatemding.service.TintucService;


@Component
public class GlobalInterceptor implements HandlerInterceptor{
	@Autowired
	CategoryService categoryService;

	@Autowired
	TintucService tintucService;
	@Autowired
	CongthucService congthucService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		 request.setAttribute("cates", categoryService.findAll()); 
		request.setAttribute("pageTin", tintucService.listAll());
		request.setAttribute("pageCong",congthucService.listAll());
		
	}
	
	
}
