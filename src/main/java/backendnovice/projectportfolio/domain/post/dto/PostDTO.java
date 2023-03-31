package backendnovice.projectportfolio.domain.post.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDTO {
    private String title;
    
    private String content;
    
    private String author;
    
    @Builder
    public PostDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
