package germanott.bank.controller;

import germanott.bank.entity.Account;
import germanott.bank.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    AccountService accountService = new AccountService();
    @GetMapping
    public ResponseEntity<Double> consultBalance(){
        Account account = accountService.getAccount(123);
        return ResponseEntity.ok(accountService.consultBalance(account));
    }
}
