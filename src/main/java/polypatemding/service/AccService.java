package polypatemding.service;


import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import polypatemding.entity.Account;
import polypatemding.repository.AccountRepository;

@Service
@Transactional
public class AccService {
    @Autowired
    private AccountRepository accRepo;

    @Autowired
    BCryptPasswordEncoder pe;

    public void updateResetPasswordToken(String token, String email) throws AccountNotFoundException {
        Account account = accRepo.findByEmail(email);
        if (account != null) {
            account.setResetPasswordToken(token);
            accRepo.save(account);
        } else {
            throw new AccountNotFoundException("Không tìm thấy email trong hệ thống " + email);
        }
    }

    public Account getByResetPasswordToken(String token) {
        return accRepo.findByResetPasswordToken(token);
    }

    public void updatePassword(Account account, String newPassword) {
        String encodedPassword = pe.encode(newPassword);
        account.setPassWord(encodedPassword);

        account.setResetPasswordToken(null);
        accRepo.save(account);
    }
    
    
    public void changePassword(Account account, String newPassword) {
        account.setPassWord(newPassword);
        account.setPasswordChangedTime(new Date());
         
        accRepo.save(account);	
    }
}
