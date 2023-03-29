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
    
    
    @PostMapping("/login")
    public ResponseEntity provideLoginValidate(AccountDTO accountDTO) {
        boolean isCorrect = accountRepository.existsByAccountIdAndAccountPassword(accountDTO.getAccountEmail(), accountDTO.getAccountPassword());
    
        ResponseFormat response;
        
        if(isCorrect) {
            response = ResponseFormat.builder()
                    .httpCode(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("올바른 회원 입니다.")
                    .build();
        }else {
            response = ResponseFormat.builder()
                    .httpCode(HttpStatus.NOT_FOUND.value())
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .message("회원을 찾을 수 없습니다.")
                    .build();
        }
        
        return new ResponseEntity(response, response.getHttpStatus());
    }
    
    @PostMapping("/register")
    public ResponseEntity provideRegisterValidate(AccountDTO accountDTO) {
        System.out.println(accountDTO.getAccountId());
        boolean isExists = accountRepository.existsByAccountId(accountDTO.getAccountId());
        
        ResponseFormat response;
        
        if(!isExists) {
            response = ResponseFormat.builder()
                    .httpCode(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("사용가능한 아이디 입니다.")
                    .build();
        }else {
            response = ResponseFormat.builder()
                    .httpCode(HttpStatus.NOT_FOUND.value())
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .message("중복된 아이디 입니다.")
                    .build();
        }
        
        return new ResponseEntity(response, response.getHttpStatus());
    }
    
}
