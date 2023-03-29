package backendnovice.projectportfolio.domain.account.domain;

import backendnovice.projectportfolio.global.domain.Role;
import backendnovice.projectportfolio.global.domain.TimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ACCOUNT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Long no;
    
    @Column(name = "id")
    private String accountId;
    
    @Column(name = "password")
    private String accountPassword;
    
    @Column(name = "email")
    private String accountEmail;
    
    @Column(name = "phone")
    private String accountPhone;
    
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role accountRole;
}