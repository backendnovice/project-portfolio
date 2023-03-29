package backendnovice.projectportfolio.domain.account.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class AccountDTO {
    private String username;
    
    private String password;
    
    private String email;
    
    private String phone;
    
    public boolean isAdmin;
    
    @Builder
    public AccountDTO(String username, String password, String email, String phone, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.isAdmin = false;
    }
}
