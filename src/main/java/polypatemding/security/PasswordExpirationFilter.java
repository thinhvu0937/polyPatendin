package polypatemding.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import polypatemding.entity.Account;
import polypatemding.entity.CustomerUserDetails;

@Component
public class PasswordExpirationFilter implements Filter {
	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
         
        if (isUrlExcluded(httpRequest)) {
            chain.doFilter(request, response);
            return;
        }
         
        System.out.println("PasswordExpirationFilter");
 
        Account account = getLoggedInCustomer();
         
        if (account != null && account.isPasswordExpired()) {
                showChangePasswordPage(response, httpRequest, account);        
        } else {
            chain.doFilter(httpRequest, response);
        }
         
    }
	
	private boolean isUrlExcluded(HttpServletRequest httpRequest)
	        throws IOException, ServletException {
	    String url = httpRequest.getRequestURL().toString();
	     
	    if (url.endsWith(".css") || url.endsWith(".jpg	") || url.endsWith(".js")
	            || url.endsWith("/security/change_password")) {
	        return true;
	    }
	     
	    return false;
	}
	
	private Account getLoggedInCustomer() {
	    Authentication authentication
	        = SecurityContextHolder.getContext().getAuthentication();
	    Object principal = null;
	     
	    if (authentication != null) {
	        principal = authentication.getPrincipal();
	    }
	     
	    if (principal != null && principal instanceof CustomerUserDetails) {
	        CustomerUserDetails userDetails = (CustomerUserDetails) principal;
	        return userDetails.getAccount();
	    }
	     
	    return null;
	}
	
	private void showChangePasswordPage(ServletResponse response,
	        HttpServletRequest httpRequest, Account account) throws IOException {
	    System.out.println("Customer: " + account.getFullName() + " - Password Expired:");
	    System.out.println("Last time password changed: " + account.getPasswordChangedTime());
	    System.out.println("Current time: " + new Date());
	     
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	    String redirectURL = httpRequest.getContextPath() + "/security/change_password";
	    httpResponse.sendRedirect(redirectURL);
	}
}
