package backendnovice.projectportfolio.domain.post.domain;

import backendnovice.projectportfolio.domain.account.domain.AccountEntity;
import backendnovice.projectportfolio.global.domain.TimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;
    
    @Column(name = "p_title")
    private String title;
    
    @Column(name = "p_content")
    private String content;

    @Column(name = "p_author")
    private String author;
    
    @Column(name = "p_views")
    private int views = 0;
    
    @ManyToOne
    @JoinColumn(name = "p_account")
    private AccountEntity account;
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @OrderBy("id ASC")
    private List<ReplyEntity> replies = new ArrayList<>();
}
