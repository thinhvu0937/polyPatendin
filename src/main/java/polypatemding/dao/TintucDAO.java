package polypatemding.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import polypatemding.entity.Tintuc;


public interface TintucDAO extends JpaRepository <Tintuc, Integer> {

	
	@Query("SELECT t FROM Tintuc t WHERE t.Title LIKE %?1%")
	List<Tintuc> findAll(String keyword);

}
