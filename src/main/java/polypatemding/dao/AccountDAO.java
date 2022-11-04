package polypatemding.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import polypatemding.entity.Account;






public interface AccountDAO extends JpaRepository<Account, String> {
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();
	
	@Query("SELECT ac FROM Account ac WHERE ac.userName LIKE %?1%")
	List<Account> findAll(String keyword);

}
