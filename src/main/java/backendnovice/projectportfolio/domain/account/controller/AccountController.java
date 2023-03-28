package backendnovice.projectportfolio.domain.account.controller;

import backendnovice.projectportfolio.domain.account.application.AccountService;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @GetMapping("/login")
    public String getLoginForm() {
        return "/account/login";
    }
    
    @GetMapping("/register")
    public String getRegisterForm() {
        return "/account/register";
    }
    
    @PostMapping("/register")
    public void register(AccountDTO accountDTO) {
        if (accountService.registerAccount(accountDTO)) {
            getLoginForm();
        } else {
            getRegisterForm();
        }
    }
}
