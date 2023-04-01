package backendnovice.projectportfolio.domain.account.dao;

import backendnovice.projectportfolio.domain.account.application.AccountService;
import backendnovice.projectportfolio.domain.account.domain.Account;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;
import backendnovice.projectportfolio.global.domain.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class AccountRepositoryTests {
    
    private final AccountRepository accountRepository;
    
    @Autowired
    public AccountRepositoryTests(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    @Test
    public void insertAccountTests() {
        Account userAccount = Account.builder()
                .username("test")
                .password("password")
                .email("test@email.com")
                .phone("01012345678")
                .role(Role.ROLE_USER)
                .build();
        
        Account adminAccount = Account.builder()
                .username("test1")
                .password("password")
                .email("test1@gmail.com")
                .phone("01023456789")
                .role(Role.ROLE_ADMIN)
                .build();
        
        accountRepository.save(userAccount);
        
        accountRepository.save(adminAccount);
    }
    
    @Test
    public void findAccountTests() {
        // Good Case
        String goodUsername = "test";
        String goodPassword = "password";
        
        // Bad Case
        String badUsername = "tes";
        String badPassword = "password";
        
        boolean result = false;
        
        result = accountRepository.existsByUsernameAndPassword(goodUsername, goodPassword);
        System.out.println("GOOD: " + result);
        
        result = accountRepository.existsByUsernameAndPassword(badUsername, badPassword);
        System.out.println("BAD: " + result);
    }
    
    @Test
    @Transactional
    public void deleteAccountTests() {
        String username = "test1";
        String password = "password";
    
        accountRepository.deleteByUsernameAndPassword(username, password);
    }
    
}
