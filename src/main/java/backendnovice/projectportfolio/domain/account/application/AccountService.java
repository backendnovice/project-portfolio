package backendnovice.projectportfolio.domain.account.application;

import backendnovice.projectportfolio.domain.account.domain.AccountEntity;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;
import backendnovice.projectportfolio.global.domain.Role;

public interface AccountService {
    boolean registerAccount(AccountDTO accountDTO);
    
    boolean loginAccount(AccountDTO accountDTO);
    
    default AccountEntity dtoToEntity(AccountDTO accountDTO) {
        Role role;
        
        if (accountDTO.isAdmin()) {
            role = Role.ROLE_ADMIN;
        } else {
            role = Role.ROLE_USER;
        }
        
        AccountEntity account = AccountEntity.builder()
                .username(accountDTO.getUsername())
                .password(accountDTO.getPassword())
                .email(accountDTO.getEmail())
                .phone(accountDTO.getPhone())
                .role(role)
                .build();
        
        return account;
    }
}
