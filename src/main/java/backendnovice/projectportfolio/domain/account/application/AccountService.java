package backendnovice.projectportfolio.domain.account.application;

import backendnovice.projectportfolio.domain.account.domain.AccountEntity;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;

public interface AccountService {
    boolean registerAccount(AccountDTO accountDTO);
    
    default AccountEntity dtoToEntity(AccountDTO accountDTO) {
        AccountEntity account = AccountEntity.builder()
                .id(accountDTO.getId())
                .password(accountDTO.getPassword())
                .email(accountDTO.getEmail())
                .phone(accountDTO.getPhone())
                .build();
        return account;
    }
}
