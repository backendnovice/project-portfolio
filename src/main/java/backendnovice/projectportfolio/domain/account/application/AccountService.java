package backendnovice.projectportfolio.domain.account.application;

import backendnovice.projectportfolio.domain.account.domain.Account;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;
import backendnovice.projectportfolio.global.domain.Role;

public interface AccountService {
    
    boolean loginProcess(AccountDTO accountDTO);
    
    boolean registerProcess(AccountDTO accountDTO);
    
    default Account dtoToEntity(AccountDTO accountDTO) {
        Role role = (accountDTO.isAdmin()) ? Role.ROLE_ADMIN : Role.ROLE_USER;
        
        Account account = Account.builder()
                .username(accountDTO.getUsername())
                .password(accountDTO.getPassword())
                .email(accountDTO.getEmail())
                .phone(accountDTO.getPhone())
                .role(role)
                .build();
        
        return account;
    }
    
}
