package backendnovice.projectportfolio.domain.account.application;

import backendnovice.projectportfolio.domain.account.dao.AccountRepository;
import backendnovice.projectportfolio.domain.account.domain.AccountEntity;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    @Override
    public boolean registerAccount(AccountDTO accountDTO) {
        if (!accountRepository.existsById(accountDTO.getId())) {
            AccountEntity account = dtoToEntity(accountDTO);
            accountRepository.save(account);
            return true;
        } else {
            return false;
        }
    }
}
