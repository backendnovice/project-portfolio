package backendnovice.projectportfolio.global.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private Integer httpCode;
    private HttpStatus httpStatus;
    private String message;
    
    private Map<String, Object> body;
}
