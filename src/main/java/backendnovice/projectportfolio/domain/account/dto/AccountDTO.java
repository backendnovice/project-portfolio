package backendnovice.projectportfolio.domain.account.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    
    private String username;
    
    private String password;
    
    private String email;
    
    private String phone;
    
    @Builder.Default
    public boolean isAdmin = false;
    
}
