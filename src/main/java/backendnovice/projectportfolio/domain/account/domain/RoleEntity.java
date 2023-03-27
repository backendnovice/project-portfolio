package backendnovice.projectportfolio.domain.account.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "ROLE")
@Data
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO")
    private Long no;
    
    @Column(name = "NAME")
    private String name;
    
    @OneToMany(mappedBy = "role")
    private List<AccountEntity> accounts;
}
