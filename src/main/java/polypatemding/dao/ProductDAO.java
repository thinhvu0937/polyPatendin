package polypatemding.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import polypatemding.entity.Category;
import polypatemding.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(String cid);
	
	Page<Product> findByCategory(Category category,Pageable pageable);

	@Query("SELECT p FROM Product p WHERE p.name LIKE ?1")
	Page<Product> findByKeyword(String search, Pageable pageable);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
	List<Product> findAll(String keyword);
	
	



	
}


