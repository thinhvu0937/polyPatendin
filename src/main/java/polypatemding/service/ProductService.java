package polypatemding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import polypatemding.entity.Category;
import polypatemding.entity.Product;

public interface ProductService {

	List<Product> findAll();
	Page<Product> findAll(Pageable pageable);

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);


	Product update(Product p);

	void delete(Integer id);

	Page<Product> findByCategory(Category cate, Pageable pageable);
	Page<Product> findByKeyword(String search, Pageable pageable);
	void create(Product p);
	List<Product> findAll(String keyword);
	

	


	

}
