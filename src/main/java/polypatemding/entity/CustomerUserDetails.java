package polypatemding.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomerUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account;
	
	public CustomerUserDetails(Account account) {
		this.account = account;
	}
	
	
	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("getAuthorities");
		return this.account.getAuthorities().stream()
			.map(er -> new SimpleGrantedAuthority("ROLE_" + er.getRole().getId()))
			.peek(role -> {
				System.out.println(role);
			})
			.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return account.getPassWord();
	}

	@Override
	public String getUsername() {
		return account.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
