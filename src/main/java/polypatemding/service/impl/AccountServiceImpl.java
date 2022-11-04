package polypatemding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import polypatemding.dao.AccountDAO;
import polypatemding.dao.AuthorityDAO;
import polypatemding.entity.Account;
import polypatemding.entity.Authority;
import polypatemding.entity.Role;
import polypatemding.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO adao;
	@Autowired
	AuthorityDAO auth;
	
	@Override
	public Account findById(String username) {
		return adao.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		return adao.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		return adao.findAll();
	}

	@Autowired
	BCryptPasswordEncoder pe;
	
	@Override
	public Account create(Account ac,String roleid) {
		Authority x = new Authority();
		Role y =new Role();
		y.setId(roleid);
		x.setRole(y);
		x.setAccount(ac);
		ac.setPassWord(pe.encode(ac.getPassWord()));
		adao.save(ac);
		auth.save(x);
		
		return ac;
	}

	@Override
	public List<Account> findAll(String keyword) {
		if (keyword != null) {
			return adao.findAll(keyword);
		}
		return adao.findAll();
	}

	@Override
	public void deleteByid(String userName) {
		// TODO Auto-generated method stub
		adao.deleteById(userName);
		
	}
	
}
