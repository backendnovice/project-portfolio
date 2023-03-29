package backendnovice.projectportfolio.domain.account.api;

import backendnovice.projectportfolio.domain.account.dao.AccountRepository;
import backendnovice.projectportfolio.domain.account.domain.AccountEntity;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;
import backendnovice.projectportfolio.global.domain.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/account/api")
public class AccountAPI {
    private final AccountRepository accountRepository;
    
    @Autowired
    public AccountAPI(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    @PostMapping("/register")
    public ResponseEntity provideRegisterValidate(@RequestBody AccountDTO accountDTO) {
        boolean isExists = accountRepository.existsByUsername(accountDTO.getUsername());
        
        String message;
        ResponseFormat response;
        
        if (!isExists)
            message = "사용가능한 아이디입니다.";
        else
            message = "중복된 아이디입니다.";
        
        response = ResponseFormat.builder()
                .httpCode(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message(message)
                .success(!isExists)
                .build();
        
        return new ResponseEntity(response, response.getHttpStatus());
    }
    
}
