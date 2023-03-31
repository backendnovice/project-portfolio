package backendnovice.projectportfolio.domain.post.domain;

import backendnovice.projectportfolio.global.domain.TimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reply")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long id;
    
    @Column(name = "r_comment")
    private String comment;
    
    @Column(name = "r_author")
    private String author;
    
    @ManyToOne
    @JoinColumn(name = "r_post")
    private PostEntity post;
}
