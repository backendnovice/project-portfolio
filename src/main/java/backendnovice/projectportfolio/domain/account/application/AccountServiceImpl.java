package backendnovice.projectportfolio.domain.account.application;

import backendnovice.projectportfolio.domain.account.dao.AccountRepository;
import backendnovice.projectportfolio.domain.account.domain.Account;
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
    public boolean registerProcess(AccountDTO accountDTO) {
        if(!accountRepository.existsByUsername(accountDTO.getUsername())) {
            Account account = dtoToEntity(accountDTO);
            accountRepository.save(account);
            return true;
        }else {
            return false;
        }
    }
    
    @Override
    public boolean loginProcess(AccountDTO accountDTO) {
        return !accountRepository.existsByUsernameAndPassword(accountDTO.getUsername(), accountDTO.getPassword());
    }
    
}
