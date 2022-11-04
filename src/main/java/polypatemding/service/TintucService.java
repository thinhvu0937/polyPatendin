package polypatemding.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import polypatemding.entity.Tintuc;


public interface TintucService {
	 Page<Tintuc> findAll(Pageable pageable); 

	Tintuc create(Tintuc n);

	void delete(Integer id);

	  
	List<Tintuc> listAll();
	List<Tintuc> findAll(String keyword);

	Tintuc finbyid(Integer id);

	
	

	
	
	


	

}
