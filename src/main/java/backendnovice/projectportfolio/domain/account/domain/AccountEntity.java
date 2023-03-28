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
    @Column(name = "NO")
    private Long no;
    
    @Column(name = "ID")
    private String id;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PHONE")
    private String phone;
    
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;
}