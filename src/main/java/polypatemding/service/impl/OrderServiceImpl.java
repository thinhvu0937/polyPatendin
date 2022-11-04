package polypatemding.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import polypatemding.dao.OrderDAO;
import polypatemding.dao.OrderDetailDAO;
import polypatemding.entity.Order;
import polypatemding.entity.OrderDetail;
import polypatemding.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO odao;
	
	@Autowired
	OrderDetailDAO oddao;
	
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		odao.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		oddao.saveAll(details);
		
		return order;
	}

	@Override
	public Order findById(Long id) {
		return odao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return odao.findByUsername(username);
	}
	
	@Override
	public void save(Order OD) {
		odao.save(OD);
		
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return odao.findAll();
	}
	
	
	
	@Override
	public Page<Order> findAll(Pageable pageble){
		return odao.findAll(pageble);
	}

	@Override
	public List<Order> findAll(String keyword) {
		if (keyword != null) {
			return odao.findAll(keyword);
		}
		// TODO Auto-generated method stub
		return odao.findAll();
	}

	
	

}
