package polypatemding.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import polypatemding.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {
	
	@Query("SELECT cate FROM Category cate WHERE cate.name LIKE %?1%")
	List<Category> findAll(String keyword);
}
