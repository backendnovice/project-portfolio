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
    private String id;
    
    private String password;
    
    private String email;
    
    private String phone;
    
    private boolean isAdmin = false;
}
