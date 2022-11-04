package polypatemding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polypatemding.dao.OrderDetailDAO;
import polypatemding.entity.OrderDetail;
import polypatemding.service.OrderDetailService;

@Service
public class OrderDetailServicelmpl implements OrderDetailService{

	@Autowired
	OrderDetailDAO oddao;

	@Override
	public List<OrderDetail> findAll() {
		
		return oddao.findAll();
	}
	
//	@Autowired
//	OrderAdminDAO ODdao;

//	@Override
//	public List<OrderAdmin> findAll() {
//		
//		return ODdao.findAll();
//	}

	
	@Override
	public OrderDetail create(OrderDetail OD) {
		return oddao.save(OD);
	}
	
	
}
