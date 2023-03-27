package backendnovice.projectportfolio.domain.account.dao;

import backendnovice.projectportfolio.domain.account.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    boolean existsById(@Param("ID") String id);
}