package germanott.bank.controller;

import germanott.bank.entity.Account;
import germanott.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping(path = "/{idAccount}")
    public ResponseEntity<Double> consultBalance(@PathVariable Long idAccount) throws Exception {

        return ResponseEntity.ok(accountService.getAccount(idAccount).getBalance());
    }
}
