package backendnovice.projectportfolio.domain.account.controller;

import backendnovice.projectportfolio.domain.account.application.AccountService;
import backendnovice.projectportfolio.domain.account.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    @PostMapping("/login")
    public String login(@ModelAttribute AccountDTO accountDTO) {
        if (accountService.loginAccount(accountDTO)) {
            return "redirect:/blog/home";
        } else {
            return "redirect:/account/login";
        }
    }
    
    @GetMapping("/register")
    public String getRegisterForm() {
        return "/account/register";
    }
    
    @PostMapping("/register")
    public String register(@ModelAttribute AccountDTO accountDTO) {
        if (accountService.registerAccount(accountDTO)) {
            return "redirect:/account/login";
        } else {
            return "redirect:/account/register";
        }
    }
}
