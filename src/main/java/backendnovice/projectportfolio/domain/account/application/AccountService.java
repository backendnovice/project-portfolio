package backendnovice.projectportfolio.domain.account.application;

import backendnovice.projectportfolio.domain.account.domain.AccountEntity;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;
import backendnovice.projectportfolio.global.domain.Role;

public interface AccountService {
    boolean registerAccount(AccountDTO accountDTO);
    
    
    default AccountEntity dtoToEntity(AccountDTO accountDTO) {
        Role role;
        
        if (accountDTO.isAdmin()) {
            role = Role.ROLE_ADMIN;
        } else {
            role = Role.ROLE_USER;
        }
        
        AccountEntity account = AccountEntity.builder()
                .accountId(accountDTO.getAccountId())
                .accountPassword(accountDTO.getAccountPassword())
                .accountEmail(accountDTO.getAccountEmail())
                .accountPhone(accountDTO.getAccountPhone())
                .accountRole(role)
                .build();
        
        return account;
    }
}
