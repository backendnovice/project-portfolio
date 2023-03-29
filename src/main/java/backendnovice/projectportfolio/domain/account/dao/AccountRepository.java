package backendnovice.projectportfolio.domain.account.dao;

import backendnovice.projectportfolio.domain.account.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    boolean existsByAccountId(@Param("id") String id);
    
    boolean existsByAccountIdAndAccountPassword(@Param("id") String email, @Param("password") String password);
}