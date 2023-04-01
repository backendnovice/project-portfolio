package backendnovice.projectportfolio.domain.account.dao;

import backendnovice.projectportfolio.domain.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
    boolean existsByUsername(String username);
    
    boolean existsByUsernameAndPassword(String username, String password);
    
    void deleteByUsernameAndPassword(String username, String password);
}
