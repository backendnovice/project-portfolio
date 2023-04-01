package backendnovice.projectportfolio.domain.board.domain;

import backendnovice.projectportfolio.domain.account.domain.Account;
import backendnovice.projectportfolio.global.domain.BaseTime;
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
public class Post extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    private String content;
    
    private String author;
    
    private int views = 0;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Account account;
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @OrderBy("id ASC")
    private List<Reply> replies = new ArrayList<>();
    
}
