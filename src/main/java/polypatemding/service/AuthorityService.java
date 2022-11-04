package polypatemding.service;

import java.util.List;

import polypatemding.entity.Account;
import polypatemding.entity.Authority;

public interface AuthorityService {

	List<Authority> findAuthoritiesOfAdministrators();

	List<Authority> findAll();

	Authority create(Authority auth);
	
	void delete(Integer id);
	List<Authority> findAll(String keyword);

	

}
