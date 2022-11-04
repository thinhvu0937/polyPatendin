package polypatemding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polypatemding.dao.AccountDAO;
import polypatemding.dao.AuthorityDAO;
import polypatemding.entity.Account;
import polypatemding.entity.Authority;
import polypatemding.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	AuthorityDAO ardao;
	@Autowired
	AccountDAO adao;
	
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = adao.getAdministrators();
		return ardao.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return ardao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return ardao.save(auth);
	}

	@Override
	public void delete(Integer id) {	
		ardao.deleteById(id);
	}

	@Override
	public List<Authority> findAll(String keyword) {
		if (keyword != null) {
			return ardao.findAll(keyword);
		}
		return ardao.findAll();
	}

	

	
}
