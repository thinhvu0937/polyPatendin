package polypatemding.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import polypatemding.entity.Congthuc;

public interface CongthucDAO extends JpaRepository<Congthuc, Integer> {

	@Query("SELECT ct FROM Congthuc ct WHERE ct.Title LIKE %?1%")
	List<Congthuc> findAll(String keyword);

}
