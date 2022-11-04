package polypatemding.dao;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import polypatemding.entity.LienHe;

public interface LienHeDAO extends JpaRepository<LienHe, String> {
	
	@Query("SELECT lh FROM LienHe lh WHERE lh.name LIKE %?1%")
	List<LienHe> findAll(String keyword);

}