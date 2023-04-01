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
    public String getLogin() {
        return "/account/signIn";
    }
    
    @PostMapping("/login")
    public String postLogin(@ModelAttribute AccountDTO accountDTO, RedirectAttributes redirectAttributes) {
        if (accountService.loginProcess(accountDTO)) {
            redirectAttributes.addFlashAttribute("message", "로그인에 성공했습니다.");
            return "redirect:/blog/home";
        } else {
            redirectAttributes.addFlashAttribute("message", "로그인에 실패했습니다.");
            return "redirect:/account/login";
        }
    }
    
    @GetMapping("/register")
    public String getRegister() {
        return "/account/register";
    }
    
    @PostMapping("/register")
    public String postRegister(@ModelAttribute AccountDTO accountDTO, RedirectAttributes redirectAttributes) {
        if (accountService.registerProcess(accountDTO)) {
            redirectAttributes.addFlashAttribute("message", "회원가입에 성공했습니다.");
            return "redirect:/account/login";
        } else {
            redirectAttributes.addFlashAttribute("message", "회원가입에 실패했습니다.");
            return "redirect:/account/register";
        }
    }
    
}
