package polypatemding.service;

import java.util.List;
import java.util.Optional;

import polypatemding.entity.Category;

public interface CategoryService {
	List<Category> findAll();

	Optional<Category> findById(Optional<String> cid);

	Category create(Category ca);
	
	List<Category> findAll(String keyword);

}
