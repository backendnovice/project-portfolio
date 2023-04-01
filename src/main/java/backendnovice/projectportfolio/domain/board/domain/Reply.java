package backendnovice.projectportfolio.domain.board.domain;

import backendnovice.projectportfolio.global.domain.BaseTime;
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
public class Reply extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String content;
    
    private String author;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;
}
