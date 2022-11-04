package polypatemding.service;

import java.util.List;

import polypatemding.entity.Account;

public interface AccountService {

	Account findById(String username);

	List<Account> getAdministrators();

	List<Account> findAll();

	Account create(Account ac, String roleid);
	List<Account> findAll(String keyword);

	void deleteByid(String userName);

}
