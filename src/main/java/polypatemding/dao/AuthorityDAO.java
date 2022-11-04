package polypatemding.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import polypatemding.entity.Account;
import polypatemding.entity.Authority;



public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);
	
	@Query("SELECT ar FROM Authority ar WHERE ar.account.userName LIKE %?1%")
	List<Authority> findAll(String keyword);

}
