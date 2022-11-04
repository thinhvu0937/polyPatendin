package polypatemding.service;

import java.util.List;

import polypatemding.entity.LienHe;
import polypatemding.entity.Tintuc;

public interface LienHeService {

	List<LienHe> findAll();

	 LienHe create(LienHe l); 

	LienHe finbyid(String name);

	void delete(String name);
	List<LienHe> findAll(String keyword);
}
