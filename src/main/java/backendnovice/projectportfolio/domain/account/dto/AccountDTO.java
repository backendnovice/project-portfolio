package backendnovice.projectportfolio.domain.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private String accountId;
    
    private String accountPassword;
    
    private String accountEmail;
    
    private String accountPhone;
    
    public boolean isAdmin;
}
