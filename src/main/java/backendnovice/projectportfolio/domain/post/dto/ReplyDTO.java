package backendnovice.projectportfolio.domain.post.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyDTO {
    private String comment;
    
    private String author;
    
    @Builder
    public ReplyDTO(String comment, String author) {
        this.comment = comment;
        this.author = author;
    }
}
