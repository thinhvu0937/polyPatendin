package polypatemding.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import polypatemding.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long>{
	
	@Query("SELECT o FROM Order o WHERE o.account.userName=?1")
	List<Order> findByUsername(String username);
	
	@Query("SELECT o FROM Order o WHERE o.account.userName LIKE %?1%"
			+ " OR o.Status LIKE %?1%")
	List<Order> findAll(String keyword);
}
