package polypatemding.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import polypatemding.entity.OrderDetail;
import polypatemding.entity.TongHop;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
	@Query("SELECT new TongHop( d.product.name, sum(d.quantity))"
			+ " FROM OrderDetail d " 
			+ " GROUP BY d.product.name ")
	List<TongHop> getTotalSoldQuntity();
}
