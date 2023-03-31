package backendnovice.projectportfolio.domain.account.domain;

import backendnovice.projectportfolio.domain.post.domain.PostEntity;
import backendnovice.projectportfolio.global.domain.Role;
import backendnovice.projectportfolio.global.domain.TimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id")
    private Long id;
    
    @Column(name = "a_username")
    private String username;
    
    @Column(name = "a_password")
    private String password;
    
    @Column(name = "a_email")
    private String email;
    
    @Column(name = "a_phone")
    private String phone;
    
    @Column(name = "a_role")
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    @OrderBy("id ASC")
    private List<PostEntity> posts = new ArrayList<>();
}