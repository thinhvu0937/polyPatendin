package polypatemding.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import polypatemding.entity.Account;

@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account, String> {
    @Query("SELECT c FROM Account c WHERE c.email = ?1")
    public Account findByEmail(String email);

    public Account findByResetPasswordToken(String token);
    

}
