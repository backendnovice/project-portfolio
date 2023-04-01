package backendnovice.projectportfolio.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    
    private Long id;
    
    private String title;
    
    private String content;
    
    private String author;
    
}
