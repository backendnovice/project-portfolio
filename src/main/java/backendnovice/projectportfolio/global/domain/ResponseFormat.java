package backendnovice.projectportfolio.global.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFormat {
    private Integer httpCode;
    private HttpStatus httpStatus;
    private String message;
}
