package polypatemding.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Accounts")

public class Account implements Serializable{
	private static final long PASSWORD_EXPIRATION_TIME = 30L * 24L * 60L * 60L * 1000L;;
	
	@Id
	@Column(name = "username")
	String userName;
	@Column(name = "password")
	String passWord;
	@Column(name = "fullname")
	String fullName;
	@Column(name = "email")
	String email;
	String photo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	Date birthDay;
	@Column(name = "address")
	String address;
	String phone;
	@Column(name = "sex")
	boolean sex;
	@Column(name = "Resetpasswordtoken")
	String resetPasswordToken;
	@Column(name = "change_password_time")
	Date passwordChangedTime;
	
	public boolean isPasswordExpired() {
        if (this.passwordChangedTime == null) return false;
         
        long currentTime = System.currentTimeMillis();
        long lastChangedTime = this.passwordChangedTime.getTime();
         
        return currentTime > lastChangedTime + PASSWORD_EXPIRATION_TIME;
    }
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;

}






