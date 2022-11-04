package polypatemding.service;

import java.util.List;

import polypatemding.entity.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> findAll();
//	OrderAdmin create(OrderAdmin OA);
	OrderDetail create(OrderDetail OD);
//	List<OrderDetail> findById(Long id);

}
