package backendnovice.projectportfolio.domain.account.api;

import backendnovice.projectportfolio.domain.account.dao.AccountRepository;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;
import backendnovice.projectportfolio.global.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/account/api")
public class AccountAPI {
    
    private final AccountRepository accountRepository;
    
    @Autowired
    public AccountAPI(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    @PostMapping("/login")
    public ResponseEntity<Boolean> provideIdExistence(@RequestBody AccountDTO accountDTO) {
        boolean isExists = accountRepository.existsByUsername(accountDTO.getUsername());
    
        CommonResponse response;
        
        String message = (!isExists) ? "사용가능한 아이디입니다." : "중복된 아이디입니다.";
        
        response = CommonResponse.builder()
                .httpCode(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message(message)
                .body(Map.of("isExist", isExists))
                .build();
        
        return new ResponseEntity(response, response.getHttpStatus());
    }
    
}
