package polypatemding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import polypatemding.entity.Account;
import polypatemding.entity.CustomerUserDetails;
import polypatemding.repository.AccountRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account account = accountService.findById(username);
			//account.setPassword(pe.encode(account.getPassword()));
			CustomerUserDetails user = new CustomerUserDetails(account);
			System.out.println(user.getAuthorities().toString());
			return user;
		} catch (Exception e) {
			throw new UsernameNotFoundException("Customer not found");
		}
	}

}
