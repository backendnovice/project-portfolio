package backendnovice.projectportfolio.domain.account.domain;

import backendnovice.projectportfolio.domain.board.domain.Post;
import backendnovice.projectportfolio.global.domain.Role;
import backendnovice.projectportfolio.global.domain.BaseTime;
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
public class Account extends BaseTime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private String phone;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    @OrderBy("id ASC")
    private List<Post> posts = new ArrayList<>();
    
}