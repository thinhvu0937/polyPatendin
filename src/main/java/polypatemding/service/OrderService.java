package polypatemding.service;

import java.util.List;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.databind.JsonNode;

import polypatemding.entity.Order;


public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);
	
	void save(Order OD);

	Page<Order> findAll(Pageable pageble);
	List<Order> findAll();
	List<Order> findAll(String keyword);

}
